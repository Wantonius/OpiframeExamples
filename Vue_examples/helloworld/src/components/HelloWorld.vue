<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
	<MyFirstComponent/>
	<MyPropsComponent myname="Jaska"/>
	<MyPropsComponent myname="Matti"/>
	</div>
</template>

<script>
import MyFirstComponent from './MyFirstComponent';
import MyPropsComponent from './MyPropsComponent';
export default {
  name: 'HelloWorld',
  components: {MyFirstComponent,
	MyPropsComponent
  },
  data () {
    return {
      msg: 'Hello World!!'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
