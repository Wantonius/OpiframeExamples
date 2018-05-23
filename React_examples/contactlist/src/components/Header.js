import React from "react";
import { Link } from "react-router-dom";

export default class Header extends React.Component {
  render() {
    let temp;
    if (this.props.isLogged) {
      temp =
        <div>
          <ul style={{ listStyleType: "none" }}>
            <li><Link to="/" onClick={this.props.onLogout}>Logout</Link></li>
            <li><Link to="/list">Contact list</Link></li>
            <li><Link to="/contact">Add new contact</Link></li>
          </ul>
        </div>
    } else {
      temp =
        <div>
          <ul style={{ listStyleType: "none" }}>
            <li><Link to="/">Login</Link></li>
          </ul>
        </div>
    }

    return(<div>{temp}</div>);
  }

}