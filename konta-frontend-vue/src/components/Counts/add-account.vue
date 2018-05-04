<template>
  <b-card bg-variant="light">
    <b-form  >
      <b-form-group id="groupFormAccount"
                    label="Account:"
                    label-for="accountNumber">
      <b-form-input id="accountNumber"
                      type="text"
                      v-model="info.number"
                      required
                      placeholder="Enter number of account"/>
      </b-form-group>
      <b-form-group id="groupFormDesc"
                    label="Description:"
                    label-for="description">
                    <b-form-input id="description"
                                    type="text"
                                    v-model="info.description"
                                    required
                                    placeholder="Enter a description for the account"/>
    </b-form-group>
    <b-button variant="success"  @click="addAccount">Add Account</b-button>
    </b-form>
  </b-card>
</template>
<script>
export default {
  data: function () {
    return {
      info: {
        number: '',
        description: ''
      }
    }
  },
  methods: {
    addAccount: function () {
      this.$emit('accountAdd', {payload: this.info})
    }
  }
}
</script>
