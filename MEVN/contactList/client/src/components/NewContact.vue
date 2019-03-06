<template>
  <div class="contacts">
    <h1>New Contact</h1>
    <div class="form">
      <div>
        <input type="text" name="firstName" v-bind:class="{error: this.errors[0]}" placeholder="FIRST NAME" v-model="firstName">
      </div>
      <div>
        <input type="text" name="lastName" v-bind:class="{error: this.errors[1]}" placeholder="LAST NAME" v-model="lastName">
      </div>
      <div>
        <input type="text" name="phoneNumber" v-bind:class="{error: this.errors[2]}" placeholder="XXX-YYY-ZZZZ" v-model="phoneNumber">
      </div>
      <div>
        <input
        v-bind:class="{error: this.errors[3]}"
          type="text"
          name="streetAddress"
          placeholder="STREET ADDRESS"
          v-model="streetAddress"
        >
      </div>
      <div>
        <input type="text" name="city" v-bind:class="{error: this.errors[4]}" placeholder="CITY" v-model="city">
      </div>
      <div>
        <select name="provinceCode" v-bind:class="{error: this.errors[5]}" v-model="provinceCode">
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
        <input type="text" name="postalCode" v-bind:class="{error: this.errors[6]}" placeholder="POSTAL CODE"  v-model="postalCode">
      </div>
      <div>
        <input type="text" name="email" v-bind:class="{error: this.errors[7]}" placeholder="EMAIL" v-model="email">
      </div>
      <div>
        <button class="app_contact_btn" @click="addContact()">Add Contact</button>
      </div>
    </div>
  </div>
</template>

<script>
import ContactService from "@/services/ContactService";
export default {
  name: "NewContact",
  data() {
    return {
      firstName: "",
      lastName: "",
      phoneNumber: "",
      streetAddress: "",
      city: "",
      provinceCode: "",
      postalCode: "",
      email: "",
      errors: [false, false, false, false, false, false, false, false]
    };
  },
  methods: {
    isValid: function isValid() {
      var valid = true;
      var regPhone = /^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]\d{3}[\s.-]\d{4}$/i;
      var regPostalCode = /^[A-Za-z]\d[A-Za-z][ -]?\d[A-Za-z]\d$/i;
      var regEmail = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/i;
      if (this.firstName.length <= 0) {
       this.errors[0] = true;
        valid = false;
      }else {
        this.errors[0] = false;
      }
      if (this.lastName.length <= 0) {
        this.errors[1] = true;
        valid = false;
      }else {
        this.errors[1] = false;
      }
      if (!regPhone.test(this.phoneNumber)) {
        this.errors[2] = true;
        valid = false;
      }else {
        this.errors[2] = false;
      }
      if (this.streetAddress.length <= 0) {
        this.errors[3] = true;
        valid = false;
      }else {
        this.errors[3] = false;
      }
      if (this.city.length <= 0) {
        this.errors[4] = true;
        valid = false;
      }else {
        this.errors[4] = false;
      }
      if (this.provinceCode.length <= 0) {
        this.errors[5] = true;
        valid = false;
      }else {
        this.errors[5] = false;
      }
      if (!regPostalCode.test(this.postalCode)) {
        this.errors[6] = true;
        valid = false;
      } else {
        this.errors[6] = false;
      }
      if (!regEmail.test(this.email)) {
        this.errors[7] = true;
        valid = false;
      }else {
        this.errors[7] = false;
      }
      return valid;
    },
    async addContact() {
      if (this.isValid()) {
        await ContactService.addContact({
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
      } else {
        this.$forceUpdate();
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
.error {
  background: palevioletred;
  animation: shake 0.82s cubic-bezier(.36,.07,.19,.97) both;
  transform: translate3d(0, 0, 0);
  backface-visibility: hidden;
  perspective: 1000px;
}
@keyframes shake {
  10%, 90% {
    transform: translate3d(-1px, 0, 0);
  }
  
  20%, 80% {
    transform: translate3d(2px, 0, 0);
  }

  30%, 50%, 70% {
    transform: translate3d(-4px, 0, 0);
  }

  40%, 60% {
    transform: translate3d(4px, 0, 0);
  }
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


