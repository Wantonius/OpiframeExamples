import React from "react";

class Home extends React.Component {
  render(){
    return(<p>Welcome {this.props.name} to my shopping list</p>);
  }
}

export default Home;
