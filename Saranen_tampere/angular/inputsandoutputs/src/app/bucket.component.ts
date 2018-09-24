import { Component } from '@angular/core';

@Component({
	selector:"bucket",
	templateUrl:"bucket.component.html"
})
export class Bucket {
	message:string = "";
	appleList = [{"color":"Red"},{"color":"Yellow"},{"color":"Green"}];
	colors = ["Red","Yellow","Green","Brown"];
	
	transmitMessage(color) {
		this.message = "This apple is "+color; 
	}
	
	pickApple() {
		let temp = Math.floor(Math.random()*4);
		let tempApple = {"color":this.colors[temp]}
		this.appleList.push(tempApple);
	}
}