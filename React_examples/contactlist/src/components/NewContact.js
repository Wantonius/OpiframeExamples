import React from 'react';

export default class NewContact extends React.Component {
  constructor(props) {
    super(props);
    this.state = { firstName: "", lastName: "", phone: "", email: "" };
    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  onChange(event) {
    this.setState({ [event.target.name]: event.target.value });
  }

  onSubmit(event) {
    event.preventDefault();
    let temp = {
      'firstName': this.state.firstName,
      'lastName': this.state.lastName,
      'phone': this.state.phone,
      'email': this.state.email
    };
    this.props.addContact(temp);
  }

  render() {
    return (
      <form onSubmit={this.onSubmit}>
        First name:
        <input
          type='text'
          name='firstName'
          value={this.state.firstName}
          onChange={this.onChange}
        />
        Last name:
        <input
          type='text'
          name='lastName'
          value={this.state.lastName}
          onChange={this.onChange}
        />
        Phone number:
        <input
          type='text'
          name='phone'
          value={this.state.phone}
          onChange={this.onChange}
        />
        Email:
        <input
          type='email'
          name='email'
          value={this.state.email}
          onChange={this.onChange}
        />
        <input
          type='submit'
          value='add'
        />
      </form>
    );
  }
}