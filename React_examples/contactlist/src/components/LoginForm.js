import React from 'react';

export default class LoginForm extends React.Component{
  constructor(props){
    super(props);
    this.state = {userName: "", passphrase: ""}
    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  onChange(event){
    this.setState({[event.target.name]:event.target.value});
  }

  onSubmit(event){
    event.preventDefault();
    let temp = {userName:this.state.userName,
                passphrase:this.state.passphrase};
    if(event.target.name === 'registerButton'){
      this.props.onRegister(temp);
    }
    if(event.target.name === 'loginButton'){
      this.props.onLogin(temp);
    }
    if(event.target.name === 'facebookButton'){
      this.props.onFacebook();
    }
    this.setState({userName:'',passphrase:''});
  }
  
  render(){
    return(
      <form>
        Username:
        <input 
          type='text'
          name='userName'
          value={this.state.userName}
          onChange={this.onChange}
        />
        Passphrase:
        <input 
          type='password'
          name='passphrase'
          value={this.state.passphrase}
          onChange={this.onChange}
        />
        <input
          type='button'
          onClick={this.onSubmit}
          name='loginButton'
          value='login'
        />
        <input
          type='button'
          onClick={this.onSubmit}
          name='registerButton'
          value='register'
        />
        <input
          type='button'
          onClick={this.onSubmit}
          name='facebookButton'
          value='facebook'
        />
      </form>
    );
  }
}