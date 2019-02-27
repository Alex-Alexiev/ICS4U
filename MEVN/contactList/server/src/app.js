const express = require('express')
const bodyParser = require('body-parser')
const cors = require('cors')
const morgan = require('morgan')

const app = express()
app.use(morgan('combined'))
app.use(bodyParser.json())
app.use(cors())

var mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/contacts');
var db = mongoose.connection;
db.on("error", console.error.bind(console, "connection error"));
db.once("open", function (callback) {
  console.log("connected");
});

var Contact = require("../models/contact");

app.get('/contacts', (req, res) => {
  console.log(req.param("searchparam"))
  //req.db.contact.createIndex({firstName: "text", lastName: "text"})
  if (req.param("searchparam").length > 0) {
    Contact.find({ firstName: req.param("searchparam") }, function (error, contacts) {
      if (error) {
        console.error(error);
      }
      res.send({
        contacts: contacts
      });
    }).sort({ [req.param("sorter")]: req.param("direction") });
  } else {
    Contact.find({}, function (error, contacts) {
      if (error) {
        console.error(error);
      }
      res.send({
        contacts: contacts
      });
    }).sort({ [req.param("sorter")]: req.param("direction") });
  }
});

app.post('/contacts', (req, res) => {
  var db = req.db;
  var new_contact = new Contact({
    firstName: req.body.firstName,
    lastName: req.body.lastName,
    phoneNumber: req.body.phoneNumber,
    streetAddress: req.body.streetAddress,
    city: req.body.city,
    provinceCode: req.body.provinceCode,
    postalCode: req.body.postalCode,
    email: req.body.email
  });

  new_contact.save(function (error) {
    if (error) {
      console.log(error);
    }
    res.send({
      success: true,
      message: "new contact added successfully!"
    });
  });
});

app.put('/contacts/:id', (req, res) => {
  var db = req.db;
  Contact.findById(req.params.id, function (error, contact) {
    if (error) {
      console.error(error);
    }
    contact.firstName = req.body.firstName,
      contact.lastName = req.body.lastName,
      contact.phoneNumber = req.body.phoneNumber,
      contact.streetAddress = req.body.streetAddress,
      contact.city = req.body.city,
      contact.provinceCode = req.body.provinceCode,
      contact.postalCode = req.body.postalCode,
      contact.email = req.body.email
    contact.save(function (error) {
      if (error) {
        console.log(error);
      }
      res.send({
        success: true
      });
    });
  });
});

app.get('/contact/:id', (req, res) => {
  var db = req.db;
  Contact.findById(req.params.id, function (error, contact) {
    if (error) {
      console.error(error);
    }
    res.send(contact);
  })
})

app.delete('/contact/:id', (req, res) => {
  var db = req.db;
  Contact.remove({
    _id: req.params.id
  }, function (err, contact) {
    if (err) {
      res.send(err)
    }
    res.send({
      success: true
    })
  })
})

app.listen(process.env.PORT || 8081)