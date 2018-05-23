import {Component} from '@angular/core';

@Component({
	selector:'show-test',
	templateUrl:'showtest.component.html'
})

export class MaybeShown {
	show:boolean = true;
}