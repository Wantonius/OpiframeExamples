import React from "react";
import MyForm from "./MyForm";
import MyList from "./MyList";

class Container extends React.Component{
  constructor(props){
    super(props);
    this.state = {itemList:[], id:100};
    this.willUpdate = this.willUpdate.bind(this);
  }

  willUpdate(value){
    let newArray = this.state.itemList.slice();
    value.id = this.state.id;
    value.id++;
    let temp = value.id;
    newArray.push(value);
    this.setState({id:temp,itemList:newArray});
  }

  render(){

    return(
        <div>
          <MyForm onUpdate={this.willUpdate}/>
          <hr/>
          <MyList list={this.state.itemList}/>
        </div>
    );
  }
}

export default Container;
