import Api from '@/services/Api'

export default {
    fetchDirection () {
        return Api().get('direction')
    }
}