import React from "react";

class MyList extends React.Component{
  render(){
    let myStyle = {listStyleType:"none"};
    let listItems = this.props.list.map((listItem)=>
      <li key={listItem.id.toString()}>
      First Name: {listItem.firstName} <br/>
      Last Name: {listItem.lastName} <hr/>
      </li>
    );
    return(
      <ul style={myStyle}>{listItems}</ul>
    );
  }
}

export default MyList;
