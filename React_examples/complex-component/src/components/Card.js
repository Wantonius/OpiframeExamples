import React from "react";
import Label from "./Label";
import Square from "./Square";

class Card extends React.Component{
  render(){
    let cardStyle = {
      height:200,
      width:150,
      padding:0,
      backgroundColor:"#FFF",
      WebkitFilter:"drop-shadow(0px 0px 5px #666)",
      filter:"drop-shadow(0px 0px 5px #666)"
    };
    return(
      <div style={cardStyle}>
        <Square color={this.props.color}/>
        <Label color={this.props.color}/>
      </div>
    );
  }
}

export default Card;
