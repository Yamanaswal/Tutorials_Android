//////////////////////////////////  Application - Imports ///////////////////////////////////////////////
const express = require("express");
//////////////////////////////// EXPRESS //////////////////////////////////
const app = express();
/////////// Load env-file. ///////////////////
const config = require("./config/config");
const path = require("path");
const { globalErrorHandler } = require("./middleware/middlewares.main");
const connectMySqlDB = require("./databases/mysql_db");
const connectMongoDB = require("./databases/mongo_db");
/////////////////////////////// Route - Imports //////////////////////////////////////
const baseRouter = require("./routes/base_router");
const serverSecurity = require("./security/server_security");

console.log("ENVIRONMENT: ", config.NODE_ENV, process.env.NODE_ENV);

//////////////////////  Connect to databases  /////////////////////////////////
connectMySqlDB;
// connectMongoDB();

//////////////////////////////// EXPRESS - PUG TEMPLATE ENGINE //////////////////////////////////
app.set("view engine", "pug");
app.set("views", path.join(__dirname, "views"));

////////////////////////  GLOBAL - MIDDLEWARES  ///////////////////////////////////

//TODO: SERVING STATIC FILES.
app.use(express.static(path.join(__dirname, "public")));

//TODO: EXPRESS JSON MIDDLEWARES.
app.use(express.json());

serverSecurity(app);

////////////////////  ROUTES  ////////////////////////////////////////////////
app.get("/", (req, res) => {
  res.status(200).render("base", { sampleVal: "My Sample Data..." });
});

app.use("/api/v1/", baseRouter);

//////////////////// Error Handler /////////////////////////////////////////////////
app.use(globalErrorHandler);

//////////////////////////////// Server End //////////////////////////////////////
const port = config.PORT || 3000;

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
