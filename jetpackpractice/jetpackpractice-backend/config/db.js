const mongoose = require("mongoose");

const connectDB = async () => {
  const conn = await mongoose.connect(process.env.DATABASE_LOCAL, {
    useNewUrlParser: true,
  });

  console.log(
    `MongoDB Connected: ${conn.connection.host}:${conn.connection.port}`
  );
};

module.exports = connectDB;
