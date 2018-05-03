import React from "react";

class StatefulComponent extends React.Component {
  constructor(props){
    super(props);
    this.state = {seconds:0};
  }
  componentDidMount(){
    this.timerId = setInterval(
      () => this.tick(this.state.seconds), 1000
    );
  }

  componentWillUnmount(){
    clearInterval(this.timerId);
  }

  tick(counter){
    counter++;
    this.setState({seconds:counter});
  }

  render(){
    let count = this.state.seconds.toString();
    return(
      <div>
        <p>Seconds since page loaded: {count}</p>
      </div>
    );
  }
}

export default StatefulComponent;
