import React from 'react';

export default class ContactList extends React.Component {
  constructor(props){
    super(props);
    this.remove = this.remove.bind(this);
  }

  remove(event){
    this.props.onDelete(event.target.name);
  }
  
  componentDidMount() {
    this.props.updateList();
  }

  render() {
    let temp;
    if (this.props.contactList.length === 0) {
      temp = <p>No contacts on list</p>
    } else {
      let listItems = this.props.contactList.map((listItem) =>
        <tr key={listItem._id.toString()}>
          <td>{listItem.firstName}</td>
          <td>{listItem.lastName}</td>
          <td>{listItem.phone}</td>
          <td>{listItem.email}</td>
          <td><input
            type='button'
            value="Remove"
            name={listItem._id.toString()}
            onClick={this.remove}
          /></td>
        </tr>
      );
      temp =
        <table>
          <thead>
            <tr>
              <th>First name</th>
              <th>Last name</th>
              <th>Phone number</th>
              <th>Email</th>
              <th>Remove</th>
            </tr>
          </thead>
          <tbody>
            {listItems}
          </tbody>
        </table>
    }
    return (
      <div>
        <center>{temp}</center>
      </div>
    );
  }
}