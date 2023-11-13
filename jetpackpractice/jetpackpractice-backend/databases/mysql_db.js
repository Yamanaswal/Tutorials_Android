const { Sequelize } = require('sequelize');
const config = require('../config/config');

const connectMySqlDB = new Sequelize(
  config.MY_SQL_DATABASE_NAME,
  config.MY_SQL_USER,
  config.MY_SQL_PASSWORD, {
  host: config.MY_SQL_HOST,
  logging: false,
  dialect: 'mysql' /* one of 'mysql' | 'postgres' | 'sqlite' | 'mariadb' | 'mssql' | 'db2' | 'snowflake' | 'oracle' */
});

try {
  connectMySqlDB.authenticate();
  console.log('Connected to MySQL database!! - Connection has been established successfully.');

  const user = require('../models/mysql_schemas/user');
} catch (error) {
  console.error('Unable to connect to the database:', config);
}


module.exports = connectMySqlDB;