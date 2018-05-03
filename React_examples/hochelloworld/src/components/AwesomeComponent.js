import React from "react";

class AwesomeComponent extends React.Component {
  componentDidMount(){
    console.log("AwesomeComponent componentDidMount");
  }

  componentWillMount(){
    console.log("AwesomeComponent componentWillMount");    
  }

  render(){
    return(<button>Awesome</button>);
  }
}

export default AwesomeComponent;
