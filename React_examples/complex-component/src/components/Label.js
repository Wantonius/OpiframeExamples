import React from "react";

class Label extends React.Component {
  render(){
    let labelStyle = {
      fontFamily:"sans-serif",
      fontWeight:"bold",
      padding:13,
      margin:0
    };

    return(
      <p style={labelStyle}>{this.props.color}</p>
    );
  }
}

export default Label;
