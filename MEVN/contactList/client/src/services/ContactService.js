import Api from '@/services/Api'

export default {
  fetchContacts (params) {
    return Api().get('contacts'+"?sorter="+params.sorter+"&direction="+params.direction+"&searchparam="+params.searchParam)
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
