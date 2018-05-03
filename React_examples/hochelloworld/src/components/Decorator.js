import React from "react";

const Decorator = (WrappedComponent) => {
  return class extends React.Component {
    componentDidMount(){
      console.log("From decorator componentDidMount");
    }

    componentWillMount(){
      console.log("From decorator componentWillMount");
    }

    render(){
      return(<WrappedComponent/>);
    }
  }
}

export default Decorator;
