<template>
  <div class="hello">
	<label>Enter item type</label>
	<input type="text" v-model="type"/>
	<br/>
	<label>Enter price</label>
	<input type="number" v-model="price"/>
	<br/>
	<label>Enter count</label>
	<input type="number" v-model="count"/>
	<br/>
	<button @click="addNew()">Add To List</button>
	<hr/>
	<ul v-if="this.$store.state.shoppingList.length">
		<li v-for="(item,index) in this.$store.state.shoppingList">
			Item: {{item.type}}, Price:{{item.price}}, Count:{{item.count}} <button @click="remove(index)">Remove</button></li>
	</ul>
	<p v-else>
		Nothing on the shoppingList
	</p>
  </div>
</template>

<script>
export default {
  name: 'SimpleList',
  data () {
    return {
		type:"",
		price:0,
		count:0
    }
  },
  methods: {
	addNew: function() {
		let tempItem = {
			type:this.type,
			price:this.price,
			count:this.count
		}
		this.$store.dispatch('addToShoppingList',tempItem);
		this.type="",
		this.price=0,
		this.count=0
		},
	remove: function(index) {
		let tempId = this.$store.state.shoppingList[index].id;
		this.$store.dispatch('removeFromShoppingList',tempId);
	}
  
  }
}
</script>

