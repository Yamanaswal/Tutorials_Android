const express = require("express");
const sampleController = require("../../controllers/sampleController");

const router = express.Router();

router.post("/create", sampleController.createSample);
router.get("/get/sample", sampleController.getSample);
router.get("/get/samples", sampleController.getAllSampleUsingApiFeatures);
router.get("/update/sample", sampleController.updateSample);
router.get("/get/sample/stats", sampleController.getSampleStats);
router.get("/get/samples/radius", sampleController.getSampleWithinRadius);

module.exports = router;
