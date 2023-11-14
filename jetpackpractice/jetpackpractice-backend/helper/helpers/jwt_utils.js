const jwt = require("jsonwebtoken");
const config = require("../../config/config");

//TODO: GET JWT TOKEN (get sign jwt token.)
function getJwtSignToken(id) {
  return jwt.sign({ id: id }, config.JWT_SECRET_KEY, {
    expiresIn: config.JWT_EXPIRE_TIME,
  });
}

//TODO: VERIFY JWT TOKEN (verify jwt token.)
function verifyJwtSignToken(token) {
  return jwt.verify(token, config.JWT_SECRET_KEY);
}

function sendTokenResponse(res, user) {
  const token = jwtUtils.getJwtSignToken(user._id);

  const cookieOptions = {
    expires: new Date(
      Date.now() + config.JWT_COOKIE_EXPIRE_TIME * 24 * 60 * 60 * 1000
    ),
    secure: true,
    httpOnly: true,
  };

  // 4) Set Cookie Production - (Only Works With HTTPS)
  if (config.NODE_ENV === "production") {
    res.cookie("jwt", token, cookieOptions);
  }

  res.status(200).json({
    status: "success",
    statusCode: 200,
    token: token,
    data: user ?? {},
  });
}

module.exports = {
  getJwtSignToken: getJwtSignToken,
  verifyJwtSignToken: verifyJwtSignToken,
  sendTokenResponse: sendTokenResponse
};
