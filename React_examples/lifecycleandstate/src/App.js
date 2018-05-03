import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import StatefulComponent from "./components/StatefulComponent";

class App extends Component {
  render() {
    return (
      <div className="App">
        <StatefulComponent/>
      </div>
    );
  }
}

export default App;
