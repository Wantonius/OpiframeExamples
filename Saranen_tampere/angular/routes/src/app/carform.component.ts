import {Component} from '@angular/core';
import {Car} from './car.model';
import {CarService} from './carservice.service';

@Component({
	selector:'car-form',
	templateUrl:'carform.component.html'
})
export class CarForm {
	
	car:Car;
	
	constructor(private _carService:CarService) {
		this.car = new Car("",0);
	}
	
	addCar() {
		this._carService.addToCarList(this.car);
		this.car = new Car("",0);
	}
}	