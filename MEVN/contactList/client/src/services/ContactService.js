import Api from '@/services/Api'

export default {
  fetchContacts () {
    return Api().get('contacts')
  }
}
