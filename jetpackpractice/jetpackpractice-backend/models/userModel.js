const mongoose = require("mongoose");
const log = require("../helper/helpers/logger");
const validator = require("validator");
const bcrypt = require("bcryptjs");
const crypto = require("crypto");

const userSchema = new mongoose.Schema(
  {
    name: {
      type: String,
      required: [true, "Please tell us your name."],
    },
    email: {
      type: String,
      required: [true, "Please add a email."],
      unique: true,
      validate: [validator.isEmail, "Please provide a valid email address."],
    },
    photo: {
      type: String,
      default: "",
    },
    password: {
      type: String,
      required: [true, "Please add a password."],
      minLength: 8,
      select: false,
    },
    passwordConfirm: {
      type: String,
      required: [true, "Please add a password confirmation."],
      select: false,
      validate: {
        // TODO: THIS IS ONLY WORK CREATE AND SAVE
        validator: function (passwordVal) {
          return this.password === passwordVal;
        },
        message: "Password are not the same",
      },
    },
    role: {
      type: String,
      enum: ["user", "admin"],
      default: "user",
    },
    createdAt: {
      type: Date,
      default: new Date(),
    },
    passwordChangedAt: {
      type: Date,
    },
    passwordResetToken: {
      type: String,
    },
    passwordResetTokenExpiration: {
      type: Date,
    },
    active: {
      type: Boolean,
      default: true,
      select: false,
    },
  },
  {
    toJSON: { virtuals: true },
    toObject: { virtuals: true },
  }
);

//TODO: PASSWORD ENCYPATION
userSchema.pre("save", async function (next) {
  // Only Runs this function if was actually modified
  if (!this.isModified("password")) {
    return next();
  }

  // Hash the password with cost of 12 salt
  this.password = await bcrypt.hash(this.password, 12);

  // Delete the old conform password
  this.passwordConfirm = undefined;

  next();
});

// TODO: UPDATE PASSWORD CHANGED AT.
userSchema.pre("save", function (next) {
  if (!this.isModified("password") || this.isNew) {
    return next();
  }

  this.passwordChangedAt = Date.now() - 1000;
  next();
});

// TODO: (SOFT DELETE) - Only Gives Results With Active State (Not Deleted Documents.)
userSchema.pre(/^find/, function (next) {
  // This Point to Current Query. Show Only True States.
  this.find({ active: { $ne: false } });
  next();
});

//TODO: PASSWORD CHECK (user enter password with UserModel password.)
userSchema.methods.correctPassword = async function (
  enterPassword,
  userPassword
) {
  return await bcrypt.compare(enterPassword, userPassword);
};

//TODO: PASSWORD CHANGED (password change after token expires...)
userSchema.methods.changePasswordAfter = async function (JWTTimestamp) {
  if (this.passwordChangedAt) {
    const changePasswordTime = parseInt(
      this.passwordChangedAt.getTime() / 1000,
      10
    );

    return JWTTimestamp < changePasswordTime;
  }

  // Not Changed
  return false;
};

userSchema.methods.createPasswordResetToken = function () {
  const resetToken = crypto.randomBytes(32).toString("hex");

  this.passwordResetToken = crypto
    .createHash("sha256")
    .update(resetToken)
    .digest("hex");

  this.passwordResetTokenExpiration = Date.now() + 10 * 60 * 1000;

  return resetToken;
};

const User = mongoose.model("User", userSchema);
module.exports = User;
