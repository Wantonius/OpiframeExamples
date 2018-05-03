<template>
  <div class="hello">
    <h1>{{ msg }}:{{childmessage}}</h1>
	<CustomEvent @my-custom-event="customeventhandler(...arguments)"/>
  </div>
</template>

<script>
import CustomEvent from './CustomEvent';

export default {
  name: 'HelloWorld',
  components:{CustomEvent},
  data () {
    return {
      msg: 'Child Component message says:',
	  childmessage: 'No message yet'
    }
  },
  methods: {
	customeventhandler: function(data) {
		console.log("In custom event handler");
		this.childmessage = data;
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
