<template>
    <div class="direction">
        <p>Direction {{direction[0].degrees}}</p>
    </div>
</template>

<script>
import Services from '@/services/Services'
export default {
    name: 'liveView',
    data() {
        return{
            direction: []
        }
    },
    mounted () {
        this.getDirection()
    },
    methods: {
        async getDirection() {
            const response = await Services.fetchDirection()
            this.direction = response.data
        }
    }
}
</script>
