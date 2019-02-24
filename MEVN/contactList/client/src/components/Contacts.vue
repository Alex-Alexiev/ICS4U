<template>
  <div class="contacts">
    <h1>Contacts</h1>
    <div v-if="contacts.length > 0" class="table-wrap">
      <div>
        <router-link v-bind:to="{name: 'NewContact'}" class="">Add Contact</router-link>
      </div>
      <table align="center">
        <tr>
          <td>Name</td>
          <td>Phone</td>
          <td>Address</td>
          <td>City</td>
          <td>Province</td>
          <td>Postal Code</td>
          <td>Email</td>
          <td align="center">Action</td>
        </tr>
        <tr v-for="contact in contacts">
          <td>{{contact.firstName}} {{contact.lastName}}</td>
          <td>{{contact.phoneNumber}}</td>
          <td>{{contact.streetAddress}}</td>
          <td>{{contact.city}}</td>
          <td>{{contact.provinceCode}}</td>
          <td>{{contact.postalCode}}</td>
          <td>{{contact.email}}</td>
          <td align="center">
            <router-link v-bind:to="{name: 'EditContact', params: {id: contact._id}}">Edit</router-link> |
            <a href="#" @click="deleteContact(contact._id)">Delete</a>
          </td>
        </tr>
      </table>
    </div>
    <div v-else>
      There are no contacts...
      <router-link v-bind:to="{name: 'NewContact'}" class="add_contact_linik">Add contact</router-link>
    </div>
  </div>
</template>

<script>
import ContactService from '@/services/ContactService'

export default {
  name: 'Contacts',
  data () {
    return {
        contacts: []
    }
  },
  mounted () {
      this.getContacts()
  },
  methods: {
      async getContacts () {
          const response = await ContactService.fetchContacts()
          this.contacts = response.data.contacts;
      },
      async deleteContact (id) {
          await ContactService.deleteContact(id)
          this.getContacts();
          this.$router.push({name: 'Contacts'})
      }
  }
}
</script>
<style type="text/css">
.table-wrap {
  width: 60%;
  margin: 0 auto;
  text-align: center;
}
table th, table tr {
  text-align: left;
}
table thead {
  background: #f2f2f2;
}
table tr td {
  padding: 10px;
}
table tr:nth-child(odd) {
  background: #f2f2f2;
}
table tr:nth-child(1) {
  background: #4d7ef7;
  color: #fff;
}
a {
  color: #4d7ef7;
  text-decoration: none;
}
a.add_post_link {
  background: #4d7ef7;
  color: #fff;
  padding: 10px 80px;
  text-transform: uppercase;
  font-size: 12px;
  font-weight: bold;
}
</style>