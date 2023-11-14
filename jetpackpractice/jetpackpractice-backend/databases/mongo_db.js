const mongoose = require("mongoose");
const config = require("../config/config");

const connectMongoDB = async () => {
    const conn = await mongoose.connect(config.MONGO_DB_URI, {
        useNewUrlParser: true,
    });

    console.log(
        `MongoDB Connected: ${conn.connection.host}:${conn.connection.port}`
    );
};

module.exports = connectMongoDB;
