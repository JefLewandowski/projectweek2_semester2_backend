<template>
  <div class="home">
    <div v-for="(product, id) in products" :key="id">
      <p>{{product}}</p>
    </div>
    <img alt="Vue logo" src="../assets/logo.png">
    <!--<HelloWorld msg="Welcome to Your Vue.js App"/>-->
  </div>
</template>

<script>
// @ is an alias to /src
//import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'HomeView',
  computed: {
    products(){
      return this.$store.getters.getProducts
    }
  },
  /*components: {
    HelloWorld
  }*/
}
</script>
