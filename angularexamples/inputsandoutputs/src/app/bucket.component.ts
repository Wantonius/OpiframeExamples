import {Component} from '@angular/core';

@Component({
	selector:'bucket',
	templateUrl:'bucket.component.html'
})

export class Bucket {
	
	message:string = "";
	
	transmitMessage(value) {
		this.message = "The apple is "+value;
	}
	
}