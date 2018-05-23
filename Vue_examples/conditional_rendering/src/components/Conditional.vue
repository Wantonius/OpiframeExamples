<template>
<div>
	<div v-if="isLogged">
		<label>Logout</label>
		<button v-on:click="logout()">Logout</button>
	</div>
	<div v-else>
		<label>Login</label>
		<button v-on:click="login()">Login</button>
	</div>
	<p v-show="isLogged">V-IF will NOT be rendered if not true!
	 Use V-SHOW if you need to hide but render
	 This will show if  isLogged is true. It will be rendered in either case
	 </p>
</div>
</template>
<script>
export default {
	name:"Conditional",
	data() {
		return {
				isLogged:false
		}
	},
	methods: {
		login: function(event) {
			console.log("Login");
			this.isLogged = true;
		},
		logout: function(event) {
			console.log("Logout");
			this.isLogged = false;
		}
	}
}
</script>