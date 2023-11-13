const { log, AppError, jwtUtils } = require("../../helper/helper.main");
const User = require("../../models/mongo_schemas/userModel");
const tryCatchAsync = require("./try_catch_handler");

///
// ********* Protect Routes **********
//

exports.protect = tryCatchAsync(async (req, res, next) => {
  let token;
  let tokenType;

  // 1) Getting token and check if it's exists
  if (
    req.headers.authorization &&
    req.headers.authorization.startsWith("Bearer")
  ) {
    // Set token from Bearer token in header
    token = req.headers.authorization.split(" ")[1];
    tokenType = req.headers.authorization.split(" ")[0];
  }

  log(tokenType + " " + token);

  // Make sure token exists
  if (!token) {
    return next(new AppError("You are authorized to access this route", 401));
  }

  // 2) Verification token.
  const decoded = jwtUtils.verifyJwtSignToken(token);

  // 3) Check is user exists.
  const currentUser = await User.findById(decoded.id);
  
  if (!currentUser) {
    return next(new AppError("User not found", 401));
  }

  // 4) Check is user is changed password.
  if (await currentUser.changePasswordAfter(decoded.iat)) {
    return next(new AppError("User changed password.", 401));
  }

  req.user = currentUser;
  next();
});

exports.restrictTo = (...roles) => {
  return function (req, res, next) {
    if (!roles.includes(req.user.role)) {
      return next(
        new AppError("You do not have permission to access this action.", 403)
      );
    }
    next();
  };
};
