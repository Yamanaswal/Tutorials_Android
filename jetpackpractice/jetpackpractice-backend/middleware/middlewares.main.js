const globalErrorHandler = require("./middlewares/global_error_handler");
const tryCatchAsync = require("./middlewares/try_catch_handler");
const auth = require("./middlewares/auth");
const FileUpload = require("./middlewares/file_upload");

module.exports = {
  globalErrorHandler: globalErrorHandler,
  tryCatchAsync: tryCatchAsync,
  auth: auth,
  FileUpload: FileUpload,
};
