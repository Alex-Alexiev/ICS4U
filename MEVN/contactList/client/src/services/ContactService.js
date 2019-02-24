import Api from '@/services/Api'

export default {
  fetchContacts () {
    return Api().get('contacts')
  },

  addContact (params){
    return Api().post('contacts', params);
  },

  updateContact(params){
    return Api().put('contacts/'+params.id, params);
  },

  getContact(params){
    return Api().get('contact/'+params.id);
  },

  deleteContact(id){
    return Api().delete('contact/' + id)
  }
}
