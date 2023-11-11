const globalErrorHandler = require(".././middleware/middlewares/global_error_handler");
const tryCatchAsync = require(".././middleware/middlewares/try_catch_handler");
const auth = require(".././middleware/middlewares/auth");
const FileUpload = require(".././middleware/middlewares/file_upload");

module.exports = {
  globalErrorHandler: globalErrorHandler,
  tryCatchAsync: tryCatchAsync,
  auth: auth,
  FileUpload: FileUpload,
};
