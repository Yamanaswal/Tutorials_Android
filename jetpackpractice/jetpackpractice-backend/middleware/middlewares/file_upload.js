const multer = require("multer");
const sharp = require("sharp");
const log = require("../../helper/helpers/logger");
const AppError = require("../../helper/helpers/app_error");
const tryCatchAsync = require("./try_catch_handler");

class FileUpload {
  constructor(isImageProcessing = false, fileType = "image") {
    this.isImageProcessing = isImageProcessing;
    this._fileType = fileType;
    this._initFileUpload();
  }

  //TODO: Initial multer object.
  _multerImageUpload = multer();

  //TODO: Initializes the upload process with the multer.
  _initFileUpload() {
    if (this.isImageProcessing) {
      this._multerImageUpload = multer({
        storage: this._multerMemoryStorage,
        fileFilter: this._multerFilter,
      });
    } else {
      this._multerImageUpload = multer({
        storage: this._multerDiskStorage,
        fileFilter: this._multerFilter,
      });
    }
  }

  //TODO: Multer Memory Storage.
  _multerMemoryStorage = multer.memoryStorage();

  //TODO: Multer Storage Local.
  _multerDiskStorage = multer.diskStorage({
    destination: function (req, file, cb) {
      cb(null, "public/images/");
    },
    filename: function (req, file, cb) {
      const ext = file.mimetype.split("/")[1];
      cb(null, `image-${Date.now()}.${ext}`);
    },
  });

  //TODO: Multer Filter
  _multerFilter = (req, file, cb) => {
    log("Multer File: ", file);

    if (this._fileType === "image") {
      if (file.mimetype.startsWith("image")) {
        cb(null, true);
      } else {
        cb(new AppError("Not an Image. Please upload a Image File."), false);
      }
    }

    if (this._fileType === "pdf") {
      if (file.mimetype.startsWith("pdf")) {
        cb(null, true);
      } else {
        cb(new AppError("Not an Pdf. Please upload a Pdf File."), false);
      }
    }

    if (this._fileType === "file") {
      if (file.mimetype.startsWith("file")) {
        cb(null, true);
      } else {
        cb(new AppError("Not an File. Please upload a File."), false);
      }
    }
  };

  //TODO: get single image.
  singleImage = (fieldName) => this._multerImageUpload.single(fieldName);

  //TODO: get multple images.
  multpleImages = (fieldName, maxCount) =>
    this._multerImageUpload.array(fieldName, maxCount | undefined);

  //TODO: get multple images objects.
  fieldImages = (arrFields) => this._multerImageUpload.fields(arrFields);

  resizeSingleImage = (req, res, next) => {
    if (!req.file) {
      return next();
    }

    if (this.isImageProcessing === false) {
      return next(
        new AppError(
          "Image processing is disabled, please use isImageProcessing = true and fileType = image"
        )
      );
    }

    req.file.filename = `image-${Date.now()}.jpeg`;

    sharp(req.file.buffer)
      .resize(500, 500)
      .toFormat("jpeg")
      .jpeg({ quality: 90 })
      .toFile(`public/images/${req.file.filename}`);

    next();
  };

  resizeSingleImageAsync = tryCatchAsync(async (req, res, next) => {
    if (!req.file) {
      return next();
    }

    if (this.isImageProcessing === false) {
      return next(
        new AppError(
          "Image processing is disabled, please use isImageProcessing = true and fileType = image"
        )
      );
    }

    req.file.filename = `image-${Date.now()}.jpeg`;

    await sharp(req.file.buffer)
      .resize(500, 500)
      .toFormat("jpeg")
      .jpeg({ quality: 90 })
      .toFile(`public/images/${req.file.filename}`);

    next();
  });


}

module.exports = FileUpload;
