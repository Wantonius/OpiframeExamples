import React from "react";

class MyForm extends React.Component{
  constructor(props){
    super(props);

    this.state = {student:{firstName:"", lastName:""}};
    this.update = this.update.bind(this);
    this.change = this.change.bind(this);
  }

  update(event){
    if(this.state.student.firstName !== "" &&
       this.state.student.lastName !== ""){
        this.props.onUpdate(this.state.student);
        this.setState({student:{firstName:"", lastName:""}});
      }
      event.preventDefault();
  }

  change(event){
    if(event.target.name === "firstName"){
      let temp = this.state.student.lastName;
      this.setState({student:{firstName:event.target.value, lastName:temp}});
    } else {
      let temp = this.state.student.firstName;
      this.setState({student:{firstName:temp, lastName:event.target.value}});
    }
  }

  render(){
    return(
      <form onSubmit={this.update}>
        <p>First Name: <input type="text" name="firstName"
        value={this.state.student.firstName} onChange={this.change}
        autoFocus/>
        </p>
        <p>Last Name: <input type="text" name="lastName"
        value={this.state.student.lastName} onChange={this.change}/>
        </p>
        <input type="submit" value="Add"/>
      </form>
    );
  }
}

export default MyForm;
