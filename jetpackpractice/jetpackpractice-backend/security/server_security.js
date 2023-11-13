const rateLimit = require("express-rate-limit");
const helmet = require("helmet");
const mongoSanitise = require("express-mongo-sanitize");
const xss = require("xss-clean");
const morgan = require("morgan");
const config = require("../config/config");

const serverSecurity = (app) => {

    //TODO: 1) Set Security HTTP Headers
    app.use(helmet());

    //TODO: 2) RATE LIMITATION TO SERVER API REQUEST.
    const apiLimiter = rateLimit({
        max: 1000, // No of requests.
        windowMs: 60 * 60 * 1000, // 1 Hour Window
        message: "Too many requests from the server. please try again sometime later.",
        standardHeaders: true, // Return rate limit info in the `RateLimit-*` headers
        legacyHeaders: false, // Disable the `X-RateLimit-*` headers
    });

    // Apply the rate limiting middleware to API calls only
    app.use("/api", apiLimiter);

    //TODO: Data sanitization against NoSql Injection. (e.g. email: { "$gt": "" })
    app.use(mongoSanitise());

    //TODO: Data sanitization against XSS Attacks.
    app.use(xss());

    //TODO: SHOWS REQUEST LOG IN CONSOLE.
    if (config.NODE_ENV === "development") {
        app.use(morgan("dev"));
    }

}

module.exports = serverSecurity;