import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Card from './components/Card';

class App extends Component {
  render() {
    return (
      <div className="App">
		<Card/>
		<Card/>
      </div>
    );
  }
}

export default App;
