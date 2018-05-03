import {Component} from '@angular/core';
import {Apple} from './apple.model';

@Component({
	selector:'my-form',
	templateUrl:'myform.component.html'
})

export class MyForm {
	apples = [];
	
	apple = new Apple("");
	
	addApple() {
		this.apples.push(this.apple); 
		this.apple = new Apple("");
	}
	
	removeApple(index) {
		console.log(index);
		this.apples.splice(index,1);
	}

}