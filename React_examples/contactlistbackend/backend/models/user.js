let mongoose = require('mongoose');
let bcrypt = require('bcrypt-nodejs');

let Schema = mongoose.Schema(
  {
    local:
    {
      userName: { type: String, unique: true },
      passphrase: String
    },
    facebook:
    {
      id: String,
      token: String,
      email: String,
      name: String
    }
  });

Schema.methods.generateHash = function (passphrase) {
  return bcrypt.hashSync(passphrase, bcrypt.genSaltSync(8), null);
}

Schema.methods.isPassphraseValid = function (passphrase) {
  return bcrypt.compareSync(passphrase, this.local.passphrase);
}

module.exports = mongoose.model('User', Schema);
