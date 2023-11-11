const express = require("express");
const authController = require("../../controllers/authController");
const { auth, FileUpload } = require("../../middleware/base_middlewares");

const router = express.Router();

const fileUpload = new FileUpload(
  (isImageProcessing = true),
  (fileType = "image")
);

router.post("/user/signUp", authController.signUp);

router.post(
  "/user/signUpAdmin",
  authController.signUpAdmin
);
router.post("/user/login", authController.login);
router.get("/user/all_users", auth.protect, authController.getAllUsers);

router.post(
  "/user/forgotPassword",
  auth.protect,
  authController.forgotPassword
);

router.patch("/user/resetPassword", auth.protect, authController.resetPassword);

router.patch(
  "/user/updatePassword",
  auth.protect,
  authController.updatePassword
);
router.patch(
  "/user/updateUserData",
  auth.protect,
  fileUpload.singleImage("photo"),
  fileUpload.resizeSingleImage,
  authController.updateUserData
);

router.delete("/user/deleteUser", auth.protect, authController.deleteUser);

module.exports = router;
