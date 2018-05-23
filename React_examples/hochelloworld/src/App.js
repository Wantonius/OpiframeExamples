import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Decorator from "./components/Decorator";
import AwesomeComponent from "./components/AwesomeComponent";

class App extends Component {
  render() {
    return (
      <div className="App">
        <WrappedComponent/>
      </div>
    );
  }
}

const WrappedComponent = Decorator(AwesomeComponent);

export default App;
