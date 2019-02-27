<template>
  <div class="contacts">
    <h1>Contacts</h1>
    <div>
      <router-link v-bind:to="{name: 'NewContact'}" class>Add Contact</router-link>
    </div>
    <input
      @change="getContacts()"
      type="text"
      name="searchParam"
      placeholder="search"
      v-model="searchParam"
    >

    <div v-if="contacts.length > 0" class="table-wrap">
      <table align="center">
        <tr>
          <td @click="changeSort('firstName')">Name</td>
          <td @click="changeSort('phoneNumber')">Phone</td>
          <td @click="changeSort('streetAddress')">Address</td>
          <td @click="changeSort('city')">City</td>
          <td @click="changeSort('provinceCode')">Province</td>
          <td @click="changeSort('postalCode')">Postal Code</td>
          <td @click="changeSort('email')">Email</td>
          <td align="center">Action</td>
        </tr>
        <tr v-for="contact in paginatedData">
          <td>{{contact.firstName}} {{contact.lastName}}</td>
          <td>{{contact.phoneNumber}}</td>
          <td>{{contact.streetAddress}}</td>
          <td>{{contact.city}}</td>
          <td>{{contact.provinceCode}}</td>
          <td>{{contact.postalCode}}</td>
          <td>{{contact.email}}</td>
          <td align="center">
            <router-link v-bind:to="{name: 'EditContact', params: {id: contact._id}}">Edit</router-link>|
            <a href="#" @click="deleteContact(contact._id)">Delete</a>
          </td>
        </tr>
      </table>
      <button :disabled="pageNumber == 0" @click="prevPage">Previous</button>
      <button :disabled="pageNumber >= pageCount -1" @click="nextPage">Next</button>
    </div>
    <div v-else>There are no contacts...
      <router-link v-bind:to="{name: 'NewContact'}" class="add_contact_linik">Add contact</router-link>
    </div>
  </div>
</template>

<script>
import ContactService from "@/services/ContactService";

export default {
  name: "Contacts",
  data() {
    return {
      contacts: [],
      pageNumber: 0,
      size: 5,
      sorter: "firstName",
      sortDirection: 1,
      searchParam: ""
    };
  },
  mounted() {
    this.getContacts();
  },
  methods: {
    changeSort(sorter) {
      this.sorter = sorter;
      if (this.sortDirection == -1) this.sortDirection = 1;
      else this.sortDirection = -1;
      this.getContacts();
    },
    async getContacts() {
      const response = await ContactService.fetchContacts({
        sorter: this.sorter,
        direction: this.sortDirection,
        searchParam: this.searchParam
      });
      this.contacts = response.data.contacts;
    },
    async deleteContact(id) {
      await ContactService.deleteContact(id);
      this.getContacts();
      this.$router.push({ name: "Contacts" });
    },
    nextPage() {
      this.pageNumber++;
    },
    prevPage() {
      this.pageNumber--;
    }
  },
  computed: {
    pageCount() {
      return Math.ceil(this.contacts.length / this.size);
    },
    paginatedData() {
      var start = this.pageNumber * this.size;
      var end = start + this.size;
      return this.contacts.slice(start, end);
    }
  }
};
</script>
<style type="text/css">
.table-wrap {
  width: 60%;
  margin: 0 auto;
  text-align: center;
}
table th,
table tr {
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