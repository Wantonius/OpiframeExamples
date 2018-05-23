<template>
	<div>	
		<label>Item type:</label>
		<input type="text" v-model="shoppingitem.type"/>
		<br/>
		<label>Item price:</label>
		<input type="number" v-model="shoppingitem.price"/>
		<br/>
		<label>Item count:</label>
		<input type="number" v-model="shoppingitem.count"/>
		<br/>
		<button v-on:click="addNewItem()">Add to List</button>
		<hr/>
		<table v-if="shoppingitems.length">
			<thead>
				<tr>
					<th>Count</th>
					<th>Item</th>
					<th>Price</th>
					<th>Total Price</th>
					<th>Remove</th>
				</tr>
			</thead>
			<tbody>
				<tr v-for="(item,index) in shoppingitems" :key="item.id">
					<td>{{item.count}}</td>
					<td>{{item.type}}</td>
					<td>{{item.price}}</td>
					<td>{{item.totalprice}}</td>
					<td><button v-on:click="remove(index)">Remove</button></td>
				</tr>
			</tbody>
		</table>
		<p v-else>
			Nothing on Shoppinglist
		</p>
	</div>
</template>

<script>
	export default {
		name:"ShoppingList",
		data() {
			return {
				shoppingitems:[],
				shoppingitem:{
					type:"",
					price:0,
					count:0,
					id:0,
					totalprice:0
				},
				currentId:0,
			}
		},
		methods: {
			remove: function(index) {
				this.shoppingitems.splice(index,1);
			},
			addNewItem: function() {
				let tempItem = {
					type:this.shoppingitem.type,
					price:this.shoppingitem.price,
					count:this.shoppingitem.count,
					totalprice: this.shoppingitem.price*this.shoppingitem.count,
					id:this.currentId
				}
				this.currentId++;
				this.shoppingitem = {
					price:0,
					count:0,
					id:0,
					type:"",
					totalprice:0
				}
				this.shoppingitems.push(tempItem);
			}
		}
	
	}
</script>