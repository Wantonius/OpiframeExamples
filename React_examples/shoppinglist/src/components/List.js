import React from "react";

class List extends React.Component {
  constructor(props){
    super(props);
    this.click = this.click.bind(this);
  }

  click(event){
    this.props.callback(event.target.name);
  }

  render(){
    let listItems = this.props.list.map((listItem)=>
      <tr key={listItem.id.toString()}>
        <td>{listItem.count}</td>
        <td>{listItem.type}</td>
        <td>{listItem.price}€</td>
        <td>
          <button name={listItem.id.toString()} onClick={this.click}>
            Remove
          </button>
        </td>
      </tr>
    );
    return(
      <table>
        <thead>
          <tr>
            <th>Count</th>
            <th>Item type</th>
            <th>Price</th>
            <th>Remove</th>
          </tr>
        </thead>
        <tbody>
          {listItems}
        </tbody>
      </table>
    );
  }
}

export default List;
