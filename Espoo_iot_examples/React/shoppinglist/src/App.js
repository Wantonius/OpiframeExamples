import React, { Component } from 'react';
import ShoppingForm from './components/ShoppingForm';
import ShoppingList from './components/ShoppingList';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  constructor(props) {
	  super(props);
	  this.state= {
		  shoppingList:[],
		  id:100
	  }
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
