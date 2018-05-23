import React from "react";
import Decorator from "./Decorator";
import FirstButton from "./FirstButton";
import SecondButton from "./SecondButton";

class Container extends React.Component {
  constructor(props){
    super(props);
    this.callback = this.callback.bind(this);
    this.state = {message:""};
  }

  callback(value){
    this.setState({message:value});
  }

  render(){
    return(
      <div>
        <p>Button says:{this.state.message}</p>
        <WrappedButton callback={this.callback}/>
        <WrappedAnotherButton callback={this.callback}/>
      </div>
    );
  }
}

const WrappedButton = Decorator(FirstButton);
const WrappedAnotherButton = Decorator(SecondButton);

export default Container;
