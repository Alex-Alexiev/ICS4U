<template>
  <div class="contacts">
    <h1>Edit Contact</h1>
    <div class="form">
      <div>
        <input type="text" name="firstName" placeholder="FIRST NAME" v-model="firstName">
      </div>
      <div>
        <input type="text" name="lastName" placeholder="LAST NAME" v-model="lastName">
      </div>
      <div>
        <input type="text" name="phoneNumber" placeholder="XXX-YYY-ZZZZ" v-model="phoneNumber">
      </div>
      <div>
        <input
          type="text"
          name="streetAddress"
          placeholder="STREET ADDRESS"
          v-model="streetAddress"
        >
      </div>
      <div>
        <input type="text" name="city" placeholder="CITY" v-model="city">
      </div>
      <div>
        <select name="provinceCode" v-model="provinceCode">
          <option value="NL">NL</option>
          <option value="PE">PE</option>
          <option value="NS">NS</option>
          <option value="NB">NB</option>
          <option value="QC">QC</option>
          <option value="ON">ON</option>
          <option value="MB">MB</option>
          <option value="SK">SK</option>
          <option value="AB">AB</option>
          <option value="BC">BC</option>
          <option value="YT">YT</option>
          <option value="NT">NT</option>
          <option value="NU">NU</option>
        </select>
      </div>
      <div>
        <input type="text" name="postalCode" placeholder="POSTAL CODE" v-model="postalCode">
      </div>
      <div>
        <input type="text" name="email" placeholder="EMAIL" v-model="email">
      </div>
      <div>
        <button class="app_contact_btn" @click="updateContact">Update Contact</button>
      </div>
    </div>
  </div>
</template>

<script>
import ContactService from "@/services/ContactService";

export default {
  name: "EditContact",
  data() {
    return {
      firstName: "",
      lastName: "",
      phoneNumber: "",
      streetAddress: "",
      city: "",
      provinceCode: "",
      postalCode: "",
      email: ""
    };
  },
  mounted() {
    this.getContact();
  },
  methods: {
    isValid: function isValid() {
      var valid = true;
      var regPhone = /^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]\d{3}[\s.-]\d{4}$/i;
      var regPostalCode = /^[A-Za-z]\d[A-Za-z][ -]?\d[A-Za-z]\d$/i;
      var regEmail = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/i;
      if (this.firstName.length <= 0) {
        alert("first name");
        valid = false;
      }
      if (this.lastName.length <= 0) {
        alert("last name");
        valid = false;
      }
      if (!regPhone.test(this.phoneNumber)) {
        alert("bad phone");
        valid = false;
      }
      if (this.streetAddress.length <= 0) {
        alert("address");
        valid = false;
      }
      if (this.city.length <= 0) {
        alert("city");
        valid = false;
      }
      if (this.provinceCode.length <= 0) {
        alert("province");
        valid = false;
      }
      if (!regPostalCode.test(this.postalCode)) {
        alert("bad postal code");
        valid = false;
      }
      if (!regEmail.test(this.email)) {
        alert("bad email");
        valid = false;
      }
      return valid;
    },
    async getContact() {
      const response = await ContactService.getContact({
        id: this.$route.params.id
      });
      this.firstName = response.data.firstName;
      this.lastName = response.data.lastName;
      this.phoneNumber = response.data.phoneNumber;
      this.streetAddress = response.data.streetAddress;
      this.city = response.data.city;
      this.provinceCode = response.data.provinceCode;
      this.postalCode = response.data.postalCode;
      this.email = response.data.email;
    },
    async updateContact() {
      if (this.isValid()) {
        await ContactService.updateContact({
          id: this.$route.params.id,
          firstName: this.firstName,
          lastName: this.lastName,
          phoneNumber: this.phoneNumber,
          streetAddress: this.streetAddress,
          city: this.city,
          provinceCode: this.provinceCode,
          postalCode: this.postalCode,
          email: this.email
        });
        this.$router.push({ name: "Contacts" });
      }
    }
  }
};
</script>

<style type="text/css">
.form input,
.form textarea {
  width: 500px;
  padding: 10px;
  border: 1px solid #e0dede;
  outline: none;
  font-size: 12px;
}
.form div {
  margin: 20px;
}
.app_contact_btn {
  background: #4d7ef7;
  color: #fff;
  padding: 10px 80px;
  text-transform: uppercase;
  font-size: 12px;
  font-weight: bold;
  width: 520px;
  border: none;
  cursor: pointer;
}
</style>

