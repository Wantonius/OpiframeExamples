import React from 'react';
import Header from './Header';
import Main from './Main';

export default class Container extends React.Component {
  constructor(props) {
    super(props);
    this.state = { contactList: [], isLogged: false, token: '' };
    this.onLogin = this.onLogin.bind(this);
    this.onLogout = this.onLogout.bind(this);
    this.onRegister = this.onRegister.bind(this);
    this.updateList = this.updateList.bind(this);
    this.addContact = this.addContact.bind(this);
    this.onDelete = this.onDelete.bind(this);
    this.onFacebook = this.onFacebook.bind(this);
  }

  onLogin(data) {
    let login = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      mode: 'cors',
      body: JSON.stringify({
        'userName': data.userName,
        'passphrase': data.passphrase
      }),
      credentials: 'include'
    }
    fetch('/login', login).then((response) => {
      if (response.ok) {
        response.json().then((data) => {
          this.setState({ token: data.token, isLogged: true });
        })
      } else {
        console.log(response.statusText);
      }
    }).catch((err) => {
      console.log(err);
    });
  }

  onLogout(data) {
    let logout = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      mode: 'cors',
      body: JSON.stringify({ 'token': this.state.token }),
      credentials: 'include'
    };

    fetch('/logout', logout).then((response) => {
      if (response.ok) {
        response.json().then((data) => {
          this.setState({ token: '', isLogged: false });
        });
      } else {
        console.log(response.statusText);
      }
    }).catch((err) => {
      console.log(err);
    });
  }

  onRegister(data) {
    let register = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      mode: 'cors',
      body: JSON.stringify({
        'userName': data.userName,
        'passphrase': data.passphrase
      })
    }
    fetch('/register', register).then((response) => {
      if (response.ok) {
        response.json().then((data) => {
          alert(data.message);
        })
      } else {
        console.log(response.statusText);
      }
    }).catch((err) => {
      console.log(err);
    });
  }

  onFacebook() {
    let facebook = {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
      mode: 'no-cors',
      credentials: 'include'
    }
    fetch('/auth/facebook', facebook).then((response) => {
      console.log("response: ", response.text());
      // response.json().then((data) => {
      // console.log('Facebook login auth asldkoafsd success: ', data);
      // });
    }).catch((err) => {
      console.log(err);
    });
  }

  updateList() {
    if (this.state.token !== '') {
      let update = {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
          'token': this.state.token
        },
        mode: 'cors',
        credentials: 'include'
      }
      fetch('/api/contact', update).then((response) => {
        if (response.ok) {
          response.json().then((data) => {
            this.setState({ contactList: data });
          });
        } else {
          console.log(response.statusText);
        }
      }).catch((err) => {
        console.log(err);
      });
    }
  }

  addContact(data) {
    if (this.state.token !== '') {
      let update = {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'token': this.state.token
        },
        mode: 'cors',
        body: JSON.stringify({
          'firstName': data.firstName,
          'lastName': data.lastName,
          'phone': data.phone,
          'email': data.email
        }),
        credentials: 'include'
      }
      fetch('/api/contact', update).then((response) => {
        if (response.ok) {
          response.json().then((data) => {
            console.log(data);
          });
        } else {
          console.log(response.statusText);
        }
      }).catch((err) => {
        console.log(err);
      });
    }
  }

  onDelete(id) {
    let deleteFetch = {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json',
        'token': this.state.token
      },
      mode: 'cors',
      credentials: 'include'
    };

    fetch('/api/contact/' + id, deleteFetch).then((response) => {
      if (response.ok) {
        response.json().then((data) => {
          console.log(data);
          this.updateList();
        });
      } else {
        console.log(response.statusText);
      }
    }).catch((err) => {
      console.log(err);
    });

  }

  render() {
    return (
      <div>
        <Header
          isLogged={this.state.isLogged}
          onLogout={this.onLogout}
        />
        <Main
          contactList={this.state.contactList}
          isLogged={this.state.isLogged}
          onLogin={this.onLogin}
          onRegister={this.onRegister}
          updateList={this.updateList}
          addContact={this.addContact}
          onDelete={this.onDelete}
          onFacebook={this.onFacebook}
        />
      </div>)
  }
}
