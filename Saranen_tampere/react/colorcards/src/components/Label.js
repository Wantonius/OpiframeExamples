import React from 'react';

export default class Label extends React.Component {


	render() {
		let style = {
			fontFamily:"sans-serif",
			fontWeight:"bold",
			padding:13,
			margin:0
		}
		return(
			<p style={style} 
			onClick={this.props.onChangeColor}>{this.props.color}</p>
		)
	};
}