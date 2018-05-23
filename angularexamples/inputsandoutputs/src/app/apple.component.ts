import {Component, Input, Output, EventEmitter} from '@angular/core';

@Component({
	selector:'apple-creator',
	templateUrl:'apple.component.html'
})

export class Apple {
	@Input() apple:string;
	@Output() appleEmits = new EventEmitter();
	
	appleClick() {
		console.log("Apple Emit");
		this.appleEmits.emit(this.apple);
	}
}