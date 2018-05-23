const express = require('express');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');
const session = require('express-session');
const mongoStore = require('connect-mongo')(session);
const passport = require('passport');
const localStrategy = require('passport-local').Strategy;
const facebookStrategy = require('passport-facebook').Strategy;
const config = require('./backend/config');

const User = require('./backend/models/user');
const Router = require('./backend/contactRouter');

mongoose.Promise = global.Promise;
mongoose.connect('mongodb://localhost/contactlist', { useMongoClient: true });

let app = express();
app.use(session({
  secret: "myBestSecret",
  saveUninitialized: false,
  resave: false,
  cookie: { maxAge: 1000 * 60 * 60 * 24 },
  store: new mongoStore({
    collection: "session",
    url: "mongodb://localhost/contactsessiondb",
    ttl: 24 * 60 * 60
  })
}));

app.use(passport.initialize());
app.use(passport.session());

passport.use("local-login", new localStrategy(
  {
    usernameField: "userName",
    passwordField: "passphrase",
    passReqToCallback: true
  }, function (req, userName, passphrase, done) {
    User.findOne({ "local.userName": userName }, function (err, user) {
      if (err) {
        console.log("Login err");
        return done(err);
      }
      if (!user) {
        console.log("No user");
        return done(null, false, { 'message': 'Wrong username or passphrase' });
      }
      if (!user.isPassphraseValid(passphrase)) {
        console.log("Wrong pass");
        return done(null, false, { 'message': 'Wrong username or passphrase' });
      }
      return done(null, user);
    });
  }));

passport.use('login-facebook', new facebookStrategy(
  {
    "clientID": config.facebookAuth.clientID,
    "clientSecret": config.facebookAuth.clientSecret,
    "callbackURL": config.facebookAuth.callbackURL,
  }, function (token, refreshToken, profile, done) {
    console.log("token: ", token);
    console.log("Refresh token: ", refreshToken);
    console.log("profile: ", profile);

    process.nextTick(function () {
      User.findOne({ "facebook.id": profile.id }, function (err, user) {
        if (err) {
          return done(err);
        }
        if (user) {
          return done(null, user);
        } else {
          let newUser = new User({});
          newUser.facebook.id = profile.id;
          newUser.facebook.token = token;
          newUser.facebook.name = profile.name.givenName;
          newUser.facebook.email = profile.emails[0].value;
          newUser.save(function (err) {
            if (err) {
              return done(err);
            }
            return done(null, newUser);
          });
        }
      });
    })
  }));

passport.serializeUser(function (user, done) {
  console.log("Serialize user: " + JSON.stringify(user));
  done(null, user._id);
});

passport.deserializeUser(function (_id, done) {
  console.log("Deserialize user: " + _id);
  User.findById(_id, function (err, user) {
    if (err) {
      return console.log("Error fetching user");
    }
    return done(null, user);
  });
});

function isUserAuthenticated(req, res, next) {
  if (req.isAuthenticated()) {
    return next();
  } else {
    res.status(403).json({ 'message': 'Not allowed' });
  }
}

app.use(bodyParser.json());

// Login
app.post('/login',
  passport.authenticate('local-login', { failureRedirect: '/' }),
  function (req, res) {
    console.log("Login success");
    res.status(200).json({ 'message': 'Success', 'token': '12345' });
  });

// Register
app.post('/register', function (req, res) {
  if (req.body.userName.length > 0 && req.body.passphrase.length > 0) {

    let temp = new User({});
    temp.local.userName = req.body.userName;
    temp.local.passphrase = temp.generateHash(req.body.passphrase);
    temp.save(function (err, item) {
      if (err) {
        console.log('Register user failed');
        res.status(409).json({ 'message': 'Failure to register user' });
      } else {
        console.log('Register user successful');
        res.status(200).json({ 'message': 'Succesful' });
      }
    });
  } else {
    res.status(409).json({ 'message': 'Please enter username and passphrase' });
  }
});

// Logout
app.post('/logout', function (req, res) {
  if (req.session) {
    req.logout();
    res.status(200).json({ 'message': 'Success' });
  }
});

app.get('/auth/facebook', passport.authenticate('login-facebook',
  {
    scope: "public_profile,email"
  }));

app.get('/auth/facebook/callback', passport.authenticate('login-facebook',
  {
    successRedirect: '/list',
    failureRedirect: '/'
  }));

app.use('/api', isUserAuthenticated, Router);

port = 8080;
app.listen(port);
console.log('Running in port ', port);