import React from 'react';

export default class HelloWorld extends React.Component {  
		
	render() {
		let style = {"backgroundColor":"blue"};
		return (
			<h1 style={style}>Hello {this.props.name}</h1>
		)
	}
};
