const jwt = require("jsonwebtoken");

//TODO: GET JWT TOKEN (get sign jwt token.)
function getJwtSignToken(id) {
  return jwt.sign({ id: id }, process.env.JWT_SECRET_KEY, {
    expiresIn: process.env.JWT_EXPIRE_TIME,
  });
}

//TODO: VERIFY JWT TOKEN (verify jwt token.)
function verifyJwtSignToken(token) {
  return jwt.verify(token, process.env.JWT_SECRET_KEY);
}

module.exports = {
  getJwtSignToken: getJwtSignToken,
  verifyJwtSignToken: verifyJwtSignToken,
};
