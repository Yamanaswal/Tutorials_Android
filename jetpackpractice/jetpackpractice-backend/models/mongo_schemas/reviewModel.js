const mongoose = require("mongoose");
const { log } = require("../../helper/helper.main");

const reviewSchema = new mongoose.Schema(
  {
    review: {
      type: String,
      required: [true, "Review cannot be empty."],
    },
    rating: {
      type: Number,
      required: [true, "Please give a rating."],
      min: 1,
      max: 5,
    },
    createdAt: {
      type: Date,
      default: new Date(),
    },
    user: {
      type: mongoose.Schema.ObjectId,
      ref: "User",
      required: [true, "Review must belong to user."],
    },
    sample: {
      type: mongoose.Schema.ObjectId,
      ref: "Sample",
      required: [true, "Review must belong to sample."],
    },
  },
  {
    toJSON: { virtuals: true },
    toObject: { virtuals: true },
  }
);



module.exports = mongoose.model("Review", reviewSchema);
