import {Component} from '@angular/core';
import {Observable} from 'rxjs/Observable';

@Component({
	selector:"myobservable",
	templateUrl:"myobservable.component.html"
})
export class MyObservable {
	private data:Observable<number>;
	private values:Array<number> = [];
	private errors:boolean = false;
	private finished:boolean = false;
	
	init() {
		this.data = new Observable(observer => {
			setTimeout(() => {
				let temp = Math.random();
				if(temp < 0.15) {
					console.log(temp);
					observer.error("Random error");
					return;
				}
				observer.next(1);
			},1000);	
			setTimeout(() => {
				let temp = Math.random();
				if(temp < 0.15) {
					console.log(temp);
					observer.error("Random error");
					return;
				}
				observer.next(2);
			},2000);
			setTimeout(() => {
				let temp = Math.random();
				if(temp < 0.15) {
					console.log(temp);
					observer.error("Random error");
					return;
				}
				observer.next(3);
			},3000);			
			setTimeout(() => {
				let temp = Math.random();
				if(temp < 0.15) {
					console.log(temp);
					observer.error("Random error");
					return;
				}
				observer.next(4);
			},4000);
			setTimeout(() => {
				observer.complete();
			},5000);			
		});
		let subscription = this.data.subscribe(
			value => this.values.push(value),
			error => {
				console.log(error);	
				this.errors = true;	
			},
			() => this.finished = true
			);
	
	}
}