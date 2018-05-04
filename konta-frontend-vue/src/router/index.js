import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import CreateAccounts from '@/components/Counts/CreateAccounts'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/hello',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/CreateAccounts',
      name: 'CreateAccounts',
      component: CreateAccounts
    }
  ]
})
