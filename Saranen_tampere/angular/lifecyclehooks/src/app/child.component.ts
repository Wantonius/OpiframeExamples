import {Component, OnInit, OnChanges, Input, Output, SimpleChanges, DoCheck, AfterContentInit, AfterContentChecked, AfterViewInit, AfterViewChecked, OnDestroy, EventEmitter} from '@angular/core'

@Component({
	selector:"child",
	templateUrl:"child.component.html"
})
export class ChildComponent implements OnChanges, OnInit, DoCheck, AfterContentInit, AfterContentChecked, AfterViewInit, AfterViewChecked, OnDestroy {

	@Input() name="";
	@Output() log = new EventEmitter<string>();
	
	_verb = "set";
	_onChangesCounter:number = 0;
	ngOnChanges(changes:SimpleChanges) {
		let changeMessages:string[] = [];
		for (let propName in changes) {
			if(propName === "name") {
				let name = changes["name"].currentValue;
				changeMessages.push(`name ${this._verb} to "${name}"`)
			}			           
		}
		this._onChangesCounter++;
		this.log.emit("onChanges "+this._onChangesCounter);
		this.log.emit(changeMessages.join('; '));
		this._verb = "changed";
	}
	
	ngOnInit() {
		this.log.emit("OnInit");
	}
	
	ngDoCheck() {
		this.log.emit("DoCheck");
	}
	
	ngAfterContentInit() {
		this.log.emit("AfterContentInit");		
	}
	
	ngAfterContentChecked() {
		this.log.emit("AfterContentChecked");		
	}
	
	ngAfterViewInit() {
		this.log.emit("AfterViewInit");		
	}
	ngAfterViewChecked() {
		this.log.emit("AfterViewChecked");		
	}
	
	ngOnDestroy() {
		this.log.emit("OnDestroy");
	}
}