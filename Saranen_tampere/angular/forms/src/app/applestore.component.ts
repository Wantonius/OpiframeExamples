import {Component} from '@angular/core';
import {Apple} from './apple.model';

@Component({
	selector:"apple-store",
	templateUrl:"applestore.component.html"
})
export class AppleStore{
	apples = [];
	
	apple = new Apple("");

	addApple() {
		this.apples.push(this.apple);
		this.apple = new Apple("");
	}

	removeApple(index) {
		this.apples.splice(index,1);
	}
	
}