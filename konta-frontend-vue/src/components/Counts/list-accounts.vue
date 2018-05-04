<template>
  <div>
    <b-table :items="accounts" :fields="fields" :hover="true">
      <template slot="number" slot-scope="data">
        <!-- A custom formatted data column cell -->
        {{data.item.payload.number}}
      </template>
      <template slot="description" slot-scope="data">
        <!-- A custom formatted data column cell -->
        {{data.item.payload.description}}
      </template>
    </b-table>
  </div>
</template>
<script>
export default {
  // Options / Data
  data () {
    return {
      fields: [ 'number', 'description' ]
    }
  },
  props: ['accounts']
  // propsData: {},
  // computed: {},
  // methods: {}
  // watch: {},
  // Options / DOM
  // el () {},
  // template: '',
  // render () {},
  // Options / Lifecycle Hooks
  // beforeCreate () {},
  // created () {},
  // beforeMount () {},
  // mounted () {},
  // beforeUpdate () {},
  // updated () {},
  // activated () {},
  // deactivated () {},
  // beforeDestroy () {},
  // destroyed () {},
  // Options / Assets
  // directives: {},
  // filters: {},
  // components: {},
  // Options / Misc
  // parent: null,
  // mixins: [],
  // name: '',
  // extends: {},
  // delimiters: [ '{{', '}}' ],
  // functional: false
}
</script>
