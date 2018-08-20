import React from 'react';

export default class ShoppingForm extends React.Component {
	constructor(props) {
		super(props);
		this.state={
			type:"",
			count:0,
			price:0
		}
	}
	onChange = (event) => {
		console.log("onChange: ShoppingForm.js");
		if(event.target.name === "shoppingitemtype") {
			this.setState({
				type:event.target.value
			});
		}
		if(event.target.name === "shoppingitemcount") {
			this.setState({
				count:event.target.value
			});
		}		
		if(event.target.name === "shoppingitemprice") {
			this.setState({
				price:event.target.value
			});
		}	
	}
	
	onSubmit = (event) => {
		console.log("onSubmit: ShoppingForm.js");
		event.preventDefault();
		let shoppingItem = {
			id:0,
			type:this.state.type,
			count:this.state.count,
			price:this.state.price
		}
		this.props.addToList(shoppingItem);
	}
	
	render() {
		return(
			<form onSubmit={this.onSubmit}>
				<br/>
				Type:
				<input type="text"
					   value={this.state.type}
					   onChange={this.onChange}
					   name="shoppingitemtype"/>
				<br/>
				Count:
				<input type="number"
					   min="0"
					   step="1"
					   value={this.state.count}
					   onChange={this.onChange}
					   name="shoppingitemcount"/>			
				<br/>
				Price:
				<input type="number"
					   min="0.00"
					   step="0.01"
					   value={this.state.price}
					   onChange={this.onChange}
					   name="shoppingitemprice"/>
				<br/>
				<input type="submit" value="Add"/>
			</form>
		)	
	
	}
}