import React from "react";
import {Link} from "react-router-dom";

class Header extends React.Component{
  render(){
    return(
      <header>
        <nav>
          <ul style={{listStyleType:"none"}}>
            <li><Link to="/">Home</Link></li>
            <li><Link to="/list">List</Link></li>
            <li><Link to="/add">Add</Link></li>
            <li><Link to="/about">About</Link></li>
          </ul>
        </nav>
      </header>
    );
  }
}

export default Header;
