import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';

const state = {
	shoppingList:[]
}

const mutations = {
	addToList: function(state,message) {
		state.shoppingList = message;
	}	
}

const actions = {
	addToShoppingList({commit},newItem) {
		axios.post("http://localhost:3001/api/shoppingitem",newItem).then(function(response) {
			console.log(response);
			axios.get("http://localhost:3001/api/shoppingitem").then(function(response) {
				console.log("Get list from backend, success");
				commit('addToList',response.data);
				console.log(response.data);
			}).catch(function(error) {
				console.log(error);
			});
		}).catch(function(error) {
			console.log(error);
		});
},
	removeFromShoppingList({commit},id) {
		axios.post("http://localhost:3001/api/shoppingitem/"+id).then(function(response) {
			if(response.statusText === "OK") {
				axios.get("http://localhost:3001/api/shoppingitem").then(function(response) {
					console.log("Get list from backend, success");
					commit('addToList',response.data);
				}).catch(function(error) {
					console.log(error);
				});				
			} else {
				console.log(response.data)
			}			
		}).catch(function(error) {
			console.log(error);
		});
	}
}
Vue.use(Vuex);

export default new Vuex.Store({
	state,
	mutations,
	actions
});