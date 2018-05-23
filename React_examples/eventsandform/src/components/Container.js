import React from "react";
import FormComponent from "./FormComponent";
import Box from "./Box";

class Container extends React.Component{
  constructor(props){
    super(props);
    this.state = {color:"black"};
    this.willUpdate = this.willUpdate.bind(this);
  }

  willUpdate(value){
    console.log("willUpdate");
    this.setState({color:value});
  }

  render(){
    console.log("Container render");
    return(
      <div>
        <FormComponent onUpdate={this.willUpdate}/>
        <br/>
        <Box color={this.state.color}/>
      </div>
    );
  }
}

export default Container;
