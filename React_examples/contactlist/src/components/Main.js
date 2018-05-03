import React from 'react';
import { Switch, Route, Redirect } from 'react-router-dom';
import ContactList from './ContactList';
import NewContact from './NewContact';
import LoginForm from './LoginForm';

export default class Main extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div>
        <Switch>
          <Route
            exact path='/'
            render={() => this.props.isLogged ?
              (<Redirect to='/list' />) :
              (<LoginForm
                onLogin={this.props.onLogin}
                onRegister={this.props.onRegister}
                onFacebook={this.props.onFacebook}
              />)
            } />
          <Route
            path='/list'
            render={() => this.props.isLogged ?
              (<ContactList
                contactList={this.props.contactList}
                updateList={this.props.updateList}
                onDelete={this.props.onDelete}
              />) :
              (<Redirect to='/' />)
            } />
          <Route
            path='/contact'
            render={() => this.props.isLogged ?
              (<NewContact addContact={this.props.addContact} />) :
              (<Redirect to='/' />)
            } />
        </Switch>
      </div>
    );
  }
}