<template>
  <b-container class="bs-sample">
    <add-account v-on:accountAdd="addNewAccount"></add-account>
    <list-accounts :accounts="accounts"></list-accounts>
  </b-container>
</template>
<script>
import listAccounts from './list-accounts.vue'
import addAccount from './add-account.vue'
import axios from 'axios'
export default{
  components: {
    'list-accounts': listAccounts,
    'add-account': addAccount
  },
  data: function () {
    return {
      accounts: []
    }
  },
  methods: {
    addNewAccount: function (data) {
      axios.put('http://localhost:8182/konta-mvc/rest/accounts/AddAccount', data)
        .then(response => {
          this.todos = response.data
        })
        .catch(error => {
          console.log(error)
        })
      this.accounts.push(JSON.parse(JSON.stringify(data)))
    }
  },
  name: 'CreateAcounts'
}
</script>
