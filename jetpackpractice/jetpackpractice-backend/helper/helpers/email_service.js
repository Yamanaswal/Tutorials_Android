const nodemailer = require("nodemailer");
const pug = require("pug");
const { htmlToText } = require("html-to-text");
const log = require("./logger");

module.exports = class EmailService {
  constructor(options) {
    this.options = options;
  }

  _newTransport() {
    if (process.env.NODE_ENV === "development") {
      // Mailtrap Service.
      return nodemailer.createTransport({
        host: process.env.MAILTRAP_EMAIL_HOST,
        port: process.env.MAILTRAP_EMAIL_PORT,
        auth: {
          user: process.env.MAILTRAP_EMAIL_USERNAME,
          pass: process.env.MAILTRAP_EMAIL_PASSWORD,
        },
      });
    } else if (process.env.NODE_ENV === "production") {
      // SendGrid Service.
      return nodemailer.createTransport({
          service: 'SendGrid',
          auth: {
            user: process.env.SENDGRID_EMAIL_USERNAME,
            pass: process.env.SENDGRID_EMAIL_PASSWORD,
          }
      });
    }
  }

  sendEmail = async (template) => {


    // 2) Define Email Options.
    const mailOptions = {
      from: this.options.from,
      to: this.options.to,
      subject: this.options.subject,
      message: this.options.message,
      html: "<h1> Mail From Rest Api </h1>",
      text: htmlToText("<h1> Mail From Rest Api </h1>"),
    };

    await this._newTransport().sendMail(mailOptions);
  };
};


/* const sendEmail = async (options) => {
  // 1) Create transportor.
  var transportor = nodemailer.createTransport({
    host: "smtp.mailtrap.io",
    port: 2525,
    auth: {
      user: "c63d94db70d6c6",
      pass: "241053ef50b4df",
    },
  });

  // 2) Define Email options.
  const emailOptions = {
    from: options.from,
    to: options.email,
    subject: options.subject,
    text: options.message,
    html: "",
  };

  await transportor.sendMail(emailOptions);
};

module.exports = sendEmail;
 */