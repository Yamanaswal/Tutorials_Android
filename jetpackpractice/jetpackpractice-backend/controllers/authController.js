const User = require("../models/mongo_schemas/userModel");
const crypto = require("crypto");
const {
  log,
  jwtUtils,
  AppError,
  EmailService,
} = require("../helper/helper.main");
const { tryCatchAsync } = require("../middleware/middlewares.main");
const config = require("../config/config");
const { signUp } = require("../services/authServiceMysql");


exports.signUp = tryCatchAsync(async (req, res, next) => {
  signUp(req, res, next);
});


exports.signUpAdmin = tryCatchAsync(async (req, res, next) => {
  const { name, email, password, passwordConfirm } = req.body;

  const newUserAdmin = await User.create({
    name: name,
    email: email,
    password: password,
    passwordConfirm: passwordConfirm,
    role: "admin",
  });

  sendTokenResponse(res, newUserAdmin);
});


exports.login = tryCatchAsync(async (req, res, next) => {
  const { email, password } = req.body;

  // 1) Check if the email and password exists.
  if (!email || !password) {
    return next(new AppError("Please provide email and password.", 400));
  }

  // 2) Check if user exits and password is correct.
  const user = await User.findOne({ email }).select("+password");

  if (!user || !(await user.correctPassword(password, user.password))) {
    return next(new AppError("Incorrect email or password.", 401));
  }

  // 3) if everything is correct, send token with userdata.
  sendTokenResponse(res, user);
});

exports.getAllUsers = tryCatchAsync(async (req, res, next) => {
  const allUsers = await User.find();

  sendTokenResponse(res, allUsers);
});

exports.forgotPassword = tryCatchAsync(async (req, res, next) => {
  // 1) Get User from Email for Reset Password email address.
  const user = await User.findOne({ email: req.body.email });

  if (!user) {
    return next(new AppError("User not found.", 404));
  }

  // 2) Generate the random reset token
  const resetToken = user.createPasswordResetToken();
  await user.save({ validateBeforeSave: false }); // Save Document Without Check All Required Validations.

  // 3) Send it to User Email Address.
  const resetUrlMessage = `You are receiving this email because you (or someone else) has requested the reset of a password.
   \n Please make a PUT request to:
  ${req.protocol}://${req.headers.host}${req.baseUrl}/user/resetPassword/${resetToken}`;

  try {
    // Background thread. (asynchronous non-blocking operation).
    new EmailService({
      from: `${user.name}  <${config.SENDGRID_EMAIL_ADDRESS}>`,
      to: user.email,
      subject: "Your password reset token has been generated.",
      message: resetUrlMessage,
    }).sendEmail("welcome");

    res.status(200).json({
      statusCode: 200,
      message: "Sucessfully sent reset token.",
    });
  } catch (err) {
    user.passwordResetToken = undefined;
    user.passwordResetTokenExpiration = undefined;
    await user.save({ validateBeforeSave: false });

    next(
      new AppError(
        "There was an error sending the email. Please try again.",
        500
      )
    );
  }
});

exports.resetPassword = tryCatchAsync(async (req, resetUser) => {
  // 1) Get User based on the token.
  const hashToken = crypto
    .createHash("sha256")
    .update(req.params.token)
    .digest("hex");

  const user = await User.findOne({
    passwordResetToken: hashToken,
    passwordResetTokenExpiration: { $gt: Date.now() },
  });

  // 2) If the token not expired, there is user and set new password.
  if (!user) {
    return next(new AppError("Token is invalid or expired.", 400));
  }

  // 3) Update password,passwordResetToken,changePasswordAt property for the user.
  user.password = req.body.password;
  user.passwordConfirm = req.body.passwordConfirm;
  user.passwordResetToken = undefined;
  user.passwordResetTokenExpiration = undefined;
  await user.save();

  // 4) Log the user in, send JWT
  const token = jwtUtils.getJwtSignToken(user._id);

  res.status(200).send({
    statusCode: 200,
    message: "Password reset is sucessfully.",
    token: token,
  });
});

exports.updatePassword = tryCatchAsync(async (req, res, next) => {
  // 1) Get User from Auth Id
  const user = await User.findById(req.user.id).select("+password");

  // 2) Check if Current Password is correct.
  if (!(await user.correctPassword(req.body.passwordCurrent, user.password))) {
    return next(new AppError("Your Enter Password is Wrong.", 401));
  }

  // 3) Update Password and Save It.
  user.password = req.body.password;
  user.passwordConfirm = req.body.passwordConfirm;
  await user.save();

  res.status(200).json({
    statusCode: 200,
    message: "Password was successfully changed.",
  });
});

exports.updateUserData = tryCatchAsync(async (req, res, next) => {
  log("updateUserData: ", req.file, req.body);

  // 1) Create Error if try to update password
  if (req.body.password || req.body.passwordConfirm) {
    return next(new AppError("Your Enter Password is Wrong.", 400));
  }

  // 2) Filter out unwanted fields to not updated.
  const filterBody = filterObject(req.body, "name", "email");
  log("filterBody: ", filterBody);

  // Image Upload Validations.
  if (req.file) {
    filterBody.photo = req.file.filename;
  }

  // 3) Updated User.
  const updatedUser = await User.findByIdAndUpdate(req.user.id, filterBody, {
    new: true,
    runValidators: true,
  });

  res.status(200).json({
    statusCode: 200,
    message: "Sucessfully update data.",
    data: updatedUser,
  });
});

exports.deleteUser = tryCatchAsync(async (req, res, next) => {
  // 1) Find User and update its active status = false (delete status)
  await User.findByIdAndUpdate(req.user.id, { active: false });

  res.status(200).json({
    statusCode: 200,
    message: "Sucessfully delete user.",
  });
});

const filterObject = (obj, ...allowedFields) => {
  const newObj = {};

  Object.keys(obj).forEach((value) => {
    if (allowedFields.includes(value)) {
      newObj[value] = obj[value];
    }
  });

  return newObj;
};


