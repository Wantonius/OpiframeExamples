import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Card from "./components/Card";

class App extends Component {
  render() {
    let temp = Math.random();
    let tempComponent = null;

    if(temp > 0.5){
      tempComponent = <Card color ="blue"/>
    }else {
      tempComponent = <Card color ="green"/>
    }

    return (
      <div className="App">
        {tempComponent}
        <Card color="blue"/>
        <Card color="brown"/>
      </div>
    );
  }
}

export default App;
