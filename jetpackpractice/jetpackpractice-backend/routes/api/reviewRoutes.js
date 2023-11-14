const express = require("express");
const reviewController = require("../../controllers/reviewController");

const router = express.Router();

router.get("/all_reviews", reviewController.getAllReviews);
router.post("/create", reviewController.createReview);

module.exports = router;
