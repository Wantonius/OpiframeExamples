import React from "react";
import View from "./View";

class Mediator extends React.Component{
  render(){
    return(
      <View {...this.props}/>
    );
  }
}

export default Mediator;
