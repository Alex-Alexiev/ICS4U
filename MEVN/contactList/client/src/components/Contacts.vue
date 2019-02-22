<template>
  <div class="contacts">
    <h1>Contacts</h1>
    This file will list all the contacts.

    <div v-for="contact in contacts">
        <p> 
            <span><b>{{contact.title}}</b></span><br/>
            <span>{{contact.description}}</span>
        </p>
    </div>
  </div>
</template>

<script>
import ContactService from '@/services/ContactService'

export default {
  name: 'contacts',
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
          this.contact = response.data
      }
  }
}
</script>