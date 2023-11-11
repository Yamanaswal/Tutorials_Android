//////////////////////////////////  Application - Imports ///////////////////////////////////////////////
const express = require("express");
const multer = require("multer");
const dotenv = require("dotenv");
const path = require("path");
const morgan = require("morgan");
const rateLimit = require("express-rate-limit");
const helmet = require("helmet");
const mongoSanitise = require("express-mongo-sanitize");
const xss = require("xss-clean");
const connectDB = require("./config/db");
const { globalErrorHandler } = require("././middleware/base_middlewares");

///////////////////////////////   Route - Imports //////////////////////////////////////
const baseRouter = require("./routes/base_router");

////////////////////////////////  EXPRESS  //////////////////////////////////
const app = express();

/////////// Load env-file. ///////////////////
dotenv.config({ path: "./config/config.env" });
console.log("ENVIRONMENT: ", process.env.NODE_ENV);

//////////////////////  Connect to database  /////////////////////////////////
connectDB();

//////////////////////////////// EXPRESS - PUG TEMPLATE ENGINE //////////////////////////////////
app.set("view engine", "pug");
app.set("views", path.join(__dirname, "views"));

////////////////////////  GLOBAL - MIDDLEWARES  ///////////////////////////////////

//TODO: SERVING STATIC FILES.
app.use(express.static(path.join(__dirname, "public")));

//TODO: 1) Set Security HTTP Headers
app.use(helmet());

//TODO: 2) RATE LIMITATION TO SERVER API REQUEST.
const apiLimiter = rateLimit({
  max: 1000, // No of requests.
  windowMs: 60 * 60 * 1000, // 1 Hour Window
  message:
    "Too many requests from the server. please try again sometime later.",
  standardHeaders: true, // Return rate limit info in the `RateLimit-*` headers
  legacyHeaders: false, // Disable the `X-RateLimit-*` headers
});
// Apply the rate limiting middleware to API calls only
app.use("/api", apiLimiter);

//TODO: SHOWS REQUEST LOG IN CONSOLE.
if (process.env.NODE_ENV === "development") {
  app.use(morgan("dev"));
}

//TODO: EXPRESS JSON MIDDLEWARES.
app.use(express.json());

//TODO: Data sanitization against NoSql Injection. (e.g. email: { "$gt": "" })
app.use(mongoSanitise());

//TODO: Data sanitization against XSS Attacks.
app.use(xss());

////////////////////  ROUTES  ////////////////////////////////////////////////
app.get("/", (req, res) => {
  res.status(200).render("base", { sampleVal: "My Sample Data..." });
});

app.use("/api/v1/", baseRouter);

//////////////////// Error Handler /////////////////////////////////////////////////
app.use(globalErrorHandler);

//////////////////////////////// Server End //////////////////////////////////////
const port = process.env.PORT || 3000;

app.listen(port, () => {
  console.log(`App running on port ${port}...`);
});

//////////////////////////////// Server Error Handler //////////////////////////////////
// unhandle promise rejection - (Optional) - Stop Server
process.on("unhandledRejection", (err) => {
  console.log(`Server Error Name : ${err.name}`);
  console.log(`Server Error Message : ${err.message}`);
  ////// Close server & exit process. ////////
  // server.close(() => process.exit(1));
  // console.log("Closed Server");
});
