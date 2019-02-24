var mongoose = require("mongoose");
var Schema = mongoose.Schema;

var ContactSchema = new Schema({
    firstName: String, 
    lastName: String, 
    phoneNumber: String,
    streetAddress: String, 
    city: String, 
    provinceCode: String, 
    postalCode: String, 
    email: String
});

var Contact = mongoose.model("Contact", ContactSchema);
module.exports = Contact;