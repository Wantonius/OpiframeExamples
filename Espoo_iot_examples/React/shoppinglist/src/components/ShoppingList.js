import React from 'react';

export default class ShoppingList extends React.Component {

	
	removeItem = (event) => {
		console.log("Remove Item: ShoppingList.js")
		this.props.removeFromList(event.target.name);
	}

	render() {
		let tempList = this.props.shoppingList.map((item,index) => {
			return	  <li key={item.id}> 
				      {item.count} of {item.type} at {item.price}
					  <br/>
					  <button name={index} 
							  onClick={this.removeItem}>Remove</button>
					  </li>
					    
			}
		)
		return (
			<ul style={{listStyleType:"none"}}>
				{tempList}
			</ul>
		)
	
	}


}
