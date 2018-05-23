import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Container from "./components/Container";

class App extends Component {
  render() {
    return (
      <div className="App">
        <Container title="Professor" firstName="John" lastName="Smith"/>
        <Container title="CEO" firstName="Jane" lastName="Smith"/>
        <Container firstName="Jane" lastName="Smith"/>
      </div>
    );
  }
}

export default App;
