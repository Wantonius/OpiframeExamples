import {Component} from '@angular/core';
import {CarService} from './car.service';
import {Car} from './car.model';

@Component({
	selector:'carlist',
	templateUrl:'carlist.component.html'
})
export class CarList {
	carList: Car[];
	car: Car;

	constructor(private _carService:CarService) {
		this.getCars();
		this.car = new Car("",0);
	}
	
	getCars() {
		this.carList = this._carService.getCarList();
	}
	
	addCar() {
		this._carService.addCar(this.car);
		this.car = new Car("",0);
		this.getCars();
	}
}