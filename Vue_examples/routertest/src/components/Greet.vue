<template>
  <div class="hello">
    <h1>{{ msg }}, {{$route.params.person}}</h1>
  </div>
</template>

<script>
export default {
  name: 'Greet',
  data () {
    return {
      msg: 'Hello'
    }
  }
}
</script>