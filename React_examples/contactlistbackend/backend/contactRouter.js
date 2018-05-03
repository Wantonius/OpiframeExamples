let express = require('express');
let mongoose = require('mongoose');

let Contact = require('./models/contact');

let router = express.Router();

router.post('/contact', function (req, res) {
  let temp = new Contact({
    'firstName': req.body.firstName,
    'lastName': req.body.lastName,
    'phone': req.body.phone,
    'email': req.body.email
  });

  temp.save(function (err, item) {
    if (err) {
      console.log('Failed to save contact');
      res.status(409).json({ 'message': 'Failed to save contact' });
    } else {
      console.log('Contact saved succesfully');
      res.status(200).json({ 'message': 'Saved succesfully' });
    }
  });
});

router.get('/contact', function (req, res) {
  Contact.find(function (err, list) {
    if (err) {
      console.log('Failed to load contact list');
      res.status(404).json({ 'message': 'No list found' });
    } else {
      console.log('List loaded succesfully');
      res.status(200).json(list);
    }
  })
});

router.delete('/contact/:id', function (req, res) {
  Contact.remove({ '_id': req.params.id }, function (err) {
    if (err) {
      console.log('Failed to remove contact');
      res.status(404).json({ 'message': 'Failed to remove contact' });
    } else {
      console.log('Success');
      res.status(200).json({'message':'Success'});
    }
  });
});

module.exports = router;