const express = require("express");
const authRoutes = require("./api/authRoutes");
const sampleRoutes = require("./api/sampleRoutes");
const reviewRoutes = require("./api/reviewRoutes");

//////////////////////////////// Express Routes ********************************
const router = express.Router();

router.use("/sample", sampleRoutes);
router.use("/auth", authRoutes);
router.use("/review", reviewRoutes);

module.exports = router;
