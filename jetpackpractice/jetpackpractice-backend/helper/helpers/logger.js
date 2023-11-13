/*****************************************************************
CUSTOMIZE - CONSOLE LOG WITH COLORS.
*****************************************************************/
const config = require("../../config/config");

function log(...message) {
  if (config.NODE_ENV === "development") {
    console.log(message);
  }
}

module.exports = log;

const Bright = "\x1b[1m%s\x1b[0m";
const Hidden = "\x1b[8m%s\x1b[0m";
const Reverse = "\x1b[7m%s\x1b[0m";
const BgBlack = "\x1b[40m%s\x1b[0m";
const FgBlack = "\x1b[30m%s\x1b[0m";

// COLORS CODES for Console logging
/* "\x1b[36m%s\x1b[0m"
Reset = "\x1b[0m"
Bright = "\x1b[1m"
Dim = "\x1b[2m"
Underscore = "\x1b[4m"
Blink = "\x1b[5m"
Reverse = "\x1b[7m"
Hidden = "\x1b[8m"

FgBlack = "\x1b[30m"
FgRed = "\x1b[31m"
FgGreen = "\x1b[32m"
FgYellow = "\x1b[33m"
FgBlue = "\x1b[34m"
FgMagenta = "\x1b[35m"
FgCyan = "\x1b[36m"
FgWhite = "\x1b[37m"

BgBlack = "\x1b[40m"
BgRed = "\x1b[41m"
BgGreen = "\x1b[42m"
BgYellow = "\x1b[43m"
BgBlue = "\x1b[44m"
BgMagenta = "\x1b[45m"
BgCyan = "\x1b[46m"
BgWhite = "\x1b[47m" 
 */
