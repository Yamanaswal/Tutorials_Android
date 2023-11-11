const { log, AppError } = require("../../helper/base_helpers");

const globalErrorHandler = (err, req, res, next) => {
  log("globalErrorHandler");
  let error = { ...err };
  
  log(err);
  error.statusCode = err.statusCode || 500;
  error.status = err.status || 500;
  error.message = err.message;

  // Handle Invalid Database Ids.
  if (error.name === "CastError") error = handleCastErrorDB(error);
  if (error.code === 11000) error = handleDuplicateFieldsDB(error);
  if (error.name === "ValidationError") error = handleValidationErrorDB(error);
  if (error.name === "JsonWebTokenError") error = handleJwtError();
  if (error.name === "TokenExpiredError") error = handleJwtTokenExpiredError();

  if (process.env.NODE_ENV === "development") {
    sendErrorDev(error, res);
  } else if (process.env.NODE_ENV === "production") {
    sendErrorProd(error, res);
  }
};

const sendErrorDev = (err, res) => {
  res.status(err.statusCode).json({
    status: err.status,
    message: err.message,
    stack: err,
  });
};

const sendErrorProd = (err, res) => {
  // Operational Error.
  if (err.isOperational) {
    res.status(err.statusCode).json({
      status: err.status,
      message: err.message,
    });
  }
  // Programming Error or Unknown Error.
  else {
    console.error("ERROR: " + err);

    res.status(500).json({
      status: "Error",
      message: "Something went wrong",
    });
  }
};

const handleCastErrorDB = (err) => {
  const message = `Invalid ${err.path} : ${err.value}.`;
  return new AppError(message, 400);
};

const handleDuplicateFieldsDB = (err) => {
  const message = `Duplicate ${err.path} : ${err.value}.`;
  return new AppError(message, 400);
};

const handleValidationErrorDB = (err) => {
  const errors = Object.values(err.errors).map((el) => el.message);
  const message = `Invalid Input Data. ${errors.join("; ")}`;
  return new AppError(message, 400);
};

const handleJwtError = () => {
  return new AppError("Invalid token. Please login again.", 401);
};

const handleJwtTokenExpiredError = () => {
  return new AppError("Token Expired. Please login again.", 401);
};

module.exports = globalErrorHandler;
