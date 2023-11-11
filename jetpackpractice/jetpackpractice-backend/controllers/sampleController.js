const Sample = require(".././models/sampleModel");
const { ApiFeatures, log, AppError } = require("../helper/base_helpers");
const { tryCatchAsync } = require("../middleware/base_middlewares");

exports.createSample = tryCatchAsync(async (req, res, next) => {
  const sample = await Sample.create(req.body);
  res.status(200).json(sample);
});

exports.getSample = tryCatchAsync(async (req, res, next) => {
  const id = req.query._id;
  const sample = await Sample.findById(id).populate({
    path: "users",
    select: "-__v -status",
  });

  notFoundError(sample, next);

  // const sample = await Sample.findOne({_id: id});

  res.status(200).json(sample);
});

exports.getAllSamples = tryCatchAsync(async (req, res, next) => {
  // 1A) Filtering.
  // Get New Object From Query.
  const queryObj = { ...req.query };
  // Exclude Some
  const excludedFields = ["page", "sort", "limit"];
  excludedFields.forEach((el) => delete queryObj[el]);

  // 1B) Advance Filtering - Greater than or equal & Lesser than or equal
  let queryStr = JSON.stringify(queryObj);
  queryStr = queryStr.replace(/\b(gte|gt|lte|lt)\b/g, (match) => `$${match}`);

  let query = Sample.find(JSON.parse(queryStr));

  // 2) Sorting
  if (req.query.sort) {
    const sortBy = req.query.sort.split(",").join(" ");
    log(`Sort By: ${sortBy}`);
    query.sort(sortBy);
  } else {
    query = query.sort("-createdAt");
  }

  // 3) Fields Limiting
  if (req.query.fields) {
    const fields = req.query.fields.split(",").join(" ");
    query = query.select(fields);
    query = query.select("-__v");
  } else {
    query = query.select("-__v");
  }

  // 4) Pagination // e.g. page=2&limit=10
  const page = req.query.page || 1;
  const limit = req.query.limit || 100;
  const skip = (page - 1) * limit;
  query = query.skip(skip).limit(limit);

  // get Results from Query object
  const samples = await query;

  notFoundError(samples, next);

  res.status(200).json(samples);
});

exports.getAllSampleUsingApiFeatures = tryCatchAsync(async (req, res, next) => {
  const apiFeatures = new ApiFeatures(Sample.find(), req.query)
    .filter()
    .sort()
    .limitFields()
    .paginate();

  // get Results from Query object
  const samples = await apiFeatures.query;

  notFoundError(samples, next);

  res.status(200).json(samples);
});

exports.updateSample = tryCatchAsync(async (req, res, next) => {
  const sample = await Sample.findByIdAndUpdate(req.body);

  notFoundError(sample, next);

  res.status(200).json(sample);
});

exports.getSampleStats = tryCatchAsync(async (req, res, next) => {
  const stats = await Sample.aggregate([
    {
      $match: {
        price: { $gte: 200 },
      },
    },
    {
      $group: {
        _id: "$createAt",
        avgPrice: { $avg: "$price" },
        minPrice: { $min: "$price" },
        maxPrice: { $max: "$price" },
      },
    },
    {
      $sort: { minPrice: 1 },
    },
    {
      $addFields: { addedPrice: "$avgPrice" },
    },
    {
      $match: {
        minPrice: { $ne: 200 },
      },
    },
    {
      $sort: { maxPrice: -1 },
    },
    {
      $project: { _id: 0 },
    },
    // {
    //   $limit: 4,
    // },
  ]);

  res.status(200).json({
    status: 200,
    message: "Sample stats",
    count: stats.length,
    data: stats,
  });
});

exports.getSampleWithinRadius = tryCatchAsync(async (req, res, next) => {
  const { distance, latlng, unit } = req.query;
  const [lat, lng] = latlng.split(",");

  const radius = unit === "mi" ? distance / 3963.2 : distance / 6378.1;

  log(distance, lat, lng, radius);

  if (!lat || !lng) {
    return next(
      new AppError(
        "Please provide a lat and lng in this format: latlng:lat,lng",
        400
      )
    );
  }

  // const samples = await Sample.find({
  //   startLocation: { $geoWithin: { $centerSphere: [[lng, lat], radius] } },
  // });

  const samples = await Sample.aggregate([
    {
      $geoNear: {
        near: {
          type: "Point",
          coordinates: [lng * 1, lat * 1],
        },
        distanceField: "distance"
      },
    },
    {
      $project: {
        name: 1,
        price: 1,
        discount: 1,
        distance: 1,
      }
    }
  ]);

  notFoundError(samples, next);

  res.status(200).json({
    status: "OK",
    data: samples,
  });
});

function notFoundError(model, next) {
  if (!model) {
    next(new AppError(404, "No samples found"));
  }
}
