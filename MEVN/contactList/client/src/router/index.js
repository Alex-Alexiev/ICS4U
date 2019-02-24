import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Contacts from '@/components/Contacts'
import NewContact from '@/components/NewContact'
import EditContact from '@/components/EditContact'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/contacts',
      name: 'Contacts',
      component: Contacts
    },
    {
      path: '/contacts/new',
      name: 'NewContact',
      component: NewContact
    },
    {
      path: '/contacts/:id',
      name: 'EditContact',
      component: EditContact
    }
  ]
})
