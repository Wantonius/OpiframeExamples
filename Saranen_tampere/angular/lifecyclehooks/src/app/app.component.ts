import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'LifeCycleHooks';
  
  showChild = true;
  logs: string[] = [];
  name = "Matti"
  
  ngOnInit() {
	  setTimeout(() => this.updateChild(),10000);
	  setTimeout(() => this.hideChild(),20000);
  }
  
  updateChild() {
	  this.name = "Jaska"
  }
  
  hideChild(){
	  this.showChild = false;
  }
  
  onLog(data) {
	this.logs.push(data);
  }
}
