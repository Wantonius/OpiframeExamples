import {Component, Input, Output, EventEmitter} from '@angular/core';

@Component({
	selector:"apple",
	templateUrl:"apple.component.html"
})
export class Apple {
	@Input() color:string;
	@Output() appleEmits = new EventEmitter();

	appleClick() {
		console.log("An apple emits!");
		this.appleEmits.emit(this.color);
	}
}