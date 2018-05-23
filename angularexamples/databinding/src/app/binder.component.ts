import {Component} from '@angular/core'

@Component({
	selector:'binder',
	templateUrl:'binder.component.html'
})

export class Binder {
	welcomeText = "Hello Angular";
	clickMessage = "";
	eventMessage = "";
	
	youClicked() {
		this.clickMessage = "You called?";
	}
	
	onClickMe(value) {
		this.eventMessage = "Hello," + value;
	}
}