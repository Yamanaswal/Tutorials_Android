const mongoose = require("mongoose");
const { log } = require("../../helper/helper.main");

const sampleSchema = new mongoose.Schema(
  {
    name: {
      type: String,
      required: [true, "Please add a name."],
      default: "",
      unique: true,
      maxLength: 100,
    },
    price: {
      type: Number,
      required: [true, "Please add a price."],
      default: 0,
      min: [0, "Price cannot be less than 0."],
      max: [99999, "Price cannot be greater than 999999."],
    },
    discount: {
      type: Number,
      default: 0,
      validate: {
        validator: function (value) {
          return value < this.price;
        },
        message: "Discount must be less than price",
      },
    },
    summary: {
      type: String,
      trim: true,
    },
    images: [String],
    status: {
      type: Boolean,
      default: false,
    },
    createdAt: {
      type: Date,
      default: new Date(),
    },
    gender: {
      type: String,
      enum: {
        values: ["male", "female", "others"],
        message: "Please enter a gender.",
      },
    },
    startLocation: {
      // GeoJSON
      type: {
        type: String,
        default: "Point",
        enum: ["Point"],
      },
      coordinates: [Number],
      address: String,
      description: String,
    },
    locations: [
      {
        // GeoJSON
        type: {
          type: String,
          default: "Point",
          enum: ["Point"],
        },
        coordinates: [Number],
        address: String,
        description: String,
        day: Number,
      },
    ],
    users: [
      {
        type: mongoose.Schema.ObjectId,
        ref: "User",
      },
    ],
  },
  {
    toJSON: { virtuals: true },
    toObject: { virtuals: true },
  }
);

// Indexes
sampleSchema.index({ startLocation: "2dsphere" });

// Virtuals Properties
sampleSchema.virtual("nameAndPrice").get(function () {
  return this.name + this.price;
});

/* 
// sampleSchema.virtual("sample", {
//     ref: "Review",
//     foreignField: "sample",
//     localField: "_id",
// });
 */

// SAVE MIDDLEWARE - PRE - runs before save(), create().
// NOTE: this keyword not available
sampleSchema.pre("save", function (next) {
  log("SAVE MIDDLEWARE: PRE: ");
  next();
});

// SAVE MIDDLEWARE - POST - runs after save(), create().
// NOTE: this keyword not available
sampleSchema.post("save", function (doc, next) {
  log("SAVE MIDDLEWARE: POST: ");
  // log(doc);
  next();
});

// FIND MIDDLEWARE - QUERY MIDDLEWARE
sampleSchema.pre("find", function (next) {
  this.find({ status: { $ne: true } });
  next();
});

// AGGERATION MIDDLEWARE - Effect on Aggregate Querys
// sampleSchema.pre("aggregate", function (next) {
//   this.pipeline().unshift({ $match: { s: { $ne: true } } });
//   log(this.pipeline());
//   next();
// });

const Sample = mongoose.model("Sample", sampleSchema);
module.exports = Sample;
