import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import HelloWorld from "./components/HelloWorld";

class App extends Component {
  render() {
    return (
      <div className="App">
        <HelloWorld firstName="Jaska"/>
      </div>
    );
  }
}

export default App;
