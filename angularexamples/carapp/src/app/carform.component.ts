import {Component} from '@angular/core';
import {Car} from './car.model';
import {CarService} from './car.service';

@Component({
	selector:'carform',
	templateUrl:'carform.component.html'
})
export class CarForm {
	car:Car;
	
	constructor(private _carService:CarService){
		this.car = new Car("",0);
	}
	
	addCar() {
		this._carService.addCar(this.car).subscribe(
			data => console.log("Success in addCar:"+data),
			error => console.log("Error in addCar:"+error),
			() => console.log("addCar completed")		
		);
		this.car = new Car("",0);
	}

}