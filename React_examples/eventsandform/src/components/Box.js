import React from "react";

class Box extends React.Component{
  render(){
    let boxStyle = {height:200, width:200, backgroundColor:this.props.color};

    console.log("Box render");
    return(
      <div style={boxStyle}>
      </div>
    );
  }
}

export default Box;
