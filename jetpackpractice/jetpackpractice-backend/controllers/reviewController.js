const Review = require("./../models/reviewModel");

const {
  log,
  jwtUtils,
  AppError,
  sendEmail,
} = require("../helper/base_helpers");

const { tryCatchAsync } = require("../middleware/base_middlewares");

exports.getAllReviews = tryCatchAsync(async (req, res, next) => {
  const review = await Review.find({}).populate({
    path: "user",
    select: "-__v",
  });

  responseData(review, res);
});

exports.createReview = tryCatchAsync(async (req, res, next) => {
  const review = await Review.create(req.body);

  responseData(review, res);
});

const responseData = (review, res) => {
  res.status(200).json({
    statusCode: 200,
    message: "Review created successfully",
    data: review,
  });
};
