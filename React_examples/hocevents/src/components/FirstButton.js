import React from "react";

class FirstButton extends React.Component {
  constructor(props){
    super(props);
    this.click = this.click.bind(this);
  }

  click(event){
    this.props.callback("Hi! I'm first button");
  }

  render(){
    let buttonStyle = {backgroundColor:this.props.color};
    return(<button onClick={this.click} style={buttonStyle}>Awesome</button>);
  }
}

export default FirstButton;
