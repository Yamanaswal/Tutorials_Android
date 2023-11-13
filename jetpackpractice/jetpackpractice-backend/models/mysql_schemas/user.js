const { Sequelize, DataTypes } = require('sequelize');
const sequelize = require("../../databases/mysql_db");

module.exports = async () => {

    const User = sequelize.define('User', {
        first_name: {
            type: DataTypes.STRING,
            allowNull: false,
        },
        last_name: {
            type: DataTypes.STRING,
            allowNull: false,
            defaultValue: ""
        },
        age: {
            type: DataTypes.INTEGER
        }
    }, {
        tableName: 'users',
        // timestamps: true,
        createdAt: false,
        updatedAt: "updated_at",
    });
    
    let user = await User.sync();

    return user;
}
