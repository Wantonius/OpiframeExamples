<template>
  <div class="hello">
    <h1>{{ msg }}, {{myname}}!!</h1>
  </div>
</template>

<script>
export default {
  name: 'MyPropsComponent',
  props: ['myname'],
  data () {
    return {
      msg: 'Hello from my props component'
    }
  }
}
</script>