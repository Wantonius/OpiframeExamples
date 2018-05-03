<template>
  <div>
    <p>Enter message and press button to send</p>
	<input type="text" v-model="message"/>
	<button v-on:click="sendMessage()">Send</button>
  </div>
</template>

<script>
export default {
  name: 'CustomEvent',
  data () {
    return {
      message:""
    }
  },
  methods: {
	sendMessage: function() {
		console.log("Sending message");
		this.$emit("my-custom-event", this.message);
	}
  }
  
}
</script>