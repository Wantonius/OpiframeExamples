import React from "react";
import PropTypes from "prop-types";

class View extends React.Component {
  render(){
    return(
      <div>
        <p>{this.props.title}</p>
        <p>
          {this.props.firstName} <br/>
          {this.props.lastName}
        </p>
      </div>
    );
  }
}

View.propTypes = {
  title:PropTypes.string.isRequired,
  firstName:PropTypes.string.isRequired,
  lastName:PropTypes.string.isRequired
};

export default View;
