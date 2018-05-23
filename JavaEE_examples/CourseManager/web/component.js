/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


let Component = React.createClass({
  getInitialState:function(){
    return {list:[]};
  },
  componentDidMount:function(){
    fetch("http://localhost:8080/CourseManager/api/coursemanager/student",
    {method:"GET", mode:"cors"}).then(function(response){
      response.json().then(function(data){
        this.setState({list:data});        
      });
    });
  },
  render:function(){
    return (<p>{list}</p>);
  }
});

export default Component;