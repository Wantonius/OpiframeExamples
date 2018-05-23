let mongoose = require('mongoose');
let schema = mongoose.Schema;

module.exports = mongoose.model('contact', new schema(
  {
    firstName: String,
    lastName: String,
    phone: String,
    email: String
  }));
