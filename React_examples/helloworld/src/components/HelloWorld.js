import React from "react";

class HelloWorld extends React.Component {
  render () {
    const temp = <h1>Hello Wurld</h1>;
    return(
      <div>
        {temp}
        <h1>Hello {this.props.firstName}!</h1>
      </div>
    );
  }
}

export default HelloWorld;
