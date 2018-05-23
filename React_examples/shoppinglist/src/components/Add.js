import React from "react";
import PropTypes from "prop-types";

class Add extends React.Component {
  constructor(props) {
    super(props);
    this.update = this.update.bind(this);
    this.change = this.change.bind(this);
    this.state = {type:"", count:0, price: 0};
  }

  change(event){
    console.log("Add change");
    if(event.target.name === "item"){
      this.setState({type:event.target.value});
    } else if (event.target.name === "count") {
      this.setState({count:event.target.value});
    } else if (event.target.name === "price") {
      this.setState({price:event.target.value});
    }
  }

  update(event){
    event.preventDefault();
    console.log("Add update");
    console.log(this.state);
    if(this.state.type !== "" && this.state.count !== 0){
      console.log("Add update inside");
      let temp = {
        type:this.state.type,
        count:this.state.count,
        price:this.state.price
      };
      this.props.callback(temp);
    }
  }

  render(){
    return(
      <form onSubmit={this.update}>
        Item type:<input type="text" onChange={this.change} name="item"/>
        <br/>
        Count:<input type="number" onChange={this.change} name="count"/>
        <br/>
        Price:<input type="number" onChange={this.change} name="price"/>
        <br/>
        <input type="submit" value="ADD"/>
      </form>
    );
  }
}

Add.PropTypes = {callback:PropTypes.func.isRequired};

export default Add;
