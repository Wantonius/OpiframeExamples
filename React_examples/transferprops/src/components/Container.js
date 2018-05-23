import React from "react";
import Mediator from "./Mediator";

class Container extends React.Component {
  render(){
    return(
      <div>
        <Mediator {...this.props}/>
      </div>
    );
  }
}

export default Container;
