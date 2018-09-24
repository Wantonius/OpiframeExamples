import {Component} from '@angular/core'

@Component({
	selector:"data-binder",
	templateUrl:"databinder.component.html"
})
export class DataBinder {
	welcomeText:string = "Hello Angular";
	clickMessage = "";
	eventMessage = "";
	
	youClicked() {
		this.clickMessage = "You clicked?";
	}
	
	eventHandler(value) {
		this.eventMessage = "Hello "+value;
	}

}