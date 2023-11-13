const { jwtUtils } = require("../helper/helper.main");
const User = require("../models/mongo_schemas/userModel");

export const signUp = tryCatchAsync(async (req, res, next) => {
    const newUser = await User.create(req.body);
    jwtUtils.sendTokenResponse(res, newUser);
});


