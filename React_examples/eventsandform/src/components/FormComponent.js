import React from "react";

class FormComponent extends React.Component{
  constructor(props){
    super(props);
    this.state = {myValue:""};
    this.submit = this.submit.bind(this);
    this.change = this.change.bind(this);
  }

  submit(event){
    this.props.onUpdate(this.state.myValue);
    this.setState({myValue:""});
    event.preventDefault();
  }

  componentDidMount(){
    console.log("This is prop");
    console.log(this.props);
  }
  change(event){
    console.log(event.target.value);
    this.setState({myValue:event.target.value});
  }

  render(){
    console.log("Form component render");
    return(
      <form onSubmit={this.submit}>
        <p>Enter Color</p>
        <input autoFocus name="colorInput" type="text" value={this.state.myValue}
        onChange={this.change}/> <br/>
        <input type="submit" value="Change"/>
      </form>
    );
  }
}

export default FormComponent;
