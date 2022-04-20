import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/HomeView.vue'
import Login from '../Login.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  { path: '/loginwithtoken', name: 'loginwithtoken', component: Login },
  {
    path: '/register',
    name: 'Register product'
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router