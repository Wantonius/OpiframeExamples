<template>
<div>
	<label>Enter new message for the list:</label>
	<input v-model="newmessage" v-on:keyup.enter="addnew()"/>
	<hr></hr>
	<ul v-if="items.length">
		<li v-for="(item,index) in items" :key="item.id">
			{{index+1}}.{{item.message}}
			<button v-on:click="remove(index)">Remove</button>
		</li>
	</ul>
	<p v-else>
		Nothing on the list
	</p>
</div>
</template>

<script>
	export default {
		name:"BasicList",
		data() {
			return {
				items: [
				{message:"First Item", id:1},
				{message:"Second Item", id:2},
				{message:"Third Item", id:3}
				],
				currentId:4,
				newmessage:""
			}
		},
		methods: {
			remove: function(index){
				this.items.splice(index,1);
			},
			addnew: function() {			this.items.push({message:this.newmessage,id:this.currentId});
				this.currentId++;
				this.newmessage="";
			}
		}
	}
</script>