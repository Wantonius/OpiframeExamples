<template>
  <div id="app">
    <SimpleList/>
  </div>
</template>

<script>
import SimpleList from './components/SimpleList'

export default {
  name: 'App',
  components: {
    SimpleList
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
