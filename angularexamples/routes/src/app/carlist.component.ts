import {Component} from '@angular/core';
import {CarService} from './car.service';
import {Car} from './car.model';

@Component({
	selector:'carlist',
	templateUrl:'carlist.component.html'
})

export class CarList {
	
	carList: Car[];

	
	constructor(private _carService:CarService) {
		this.getCars();
	}
	
	getCars() {
		this.carList = this._carService.getCarList();
	}
	
	removeCar(index) {
		this._carService.removeCar(index);
	}
}