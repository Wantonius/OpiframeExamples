import React, { Component } from 'react';
import ShoppingForm from './components/ShoppingForm';
import ShoppingList from './components/ShoppingList';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  constructor(props) {
	  super(props);
	  this.state= {
		  shoppingList:[]
	  }
  }
 
  componentWillMount() {
	  this.getShoppingList();
  }  
  getShoppingList = () => {
	  let getList = {
		  method:'GET',
		  mode:'cors',
		  headers:{
			  'Content-Type':'application/json'
		  }
	  }	  
	  fetch("/api/shopping",getList).then((response) => {
			if(response.ok) {
				response.json().then((data) => {
						console.log(data);
						this.setState({
							shoppingList:data
						});
				}).catch((error) => {
					console.log(error);
				});	
			} else {
				console.log("Response not ok");
			}
	  }).catch((error) => {
			console.log("Server error:");
			console.log(error);
	  }); 	
	  }
  
  
  addToList = (item) => {
	  console.log("addToList: App.js");
	  item.id = this.state.id;
	  let tempId = this.state.id + 1;
	  let tempList = this.state.shoppingList;
	  tempList.push(item);
	  this.setState({
		  shoppingList:tempList,
		  id:tempId
	  })
	  console.log(this.state.shoppingList);
  }
  
  removeFromList = (index) => {
	  console.log("removeFromList: App.js");
	  let tempList = this.state.shoppingList;
	  tempList.splice(index,1);
	  this.setState({
		  shoppingList:tempList
	  })
  }
  
  render() {
    return (
      <div className="App">
			<ShoppingForm addToList={this.addToList}/>
			<ShoppingList shoppingList={this.state.shoppingList}
						  removeFromList={this.removeFromList}/>
      </div>
    );
  }
}

export default App;
