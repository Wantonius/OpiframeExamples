import {Component} from '@angular/core';
import {CarService} from './carservice.service';
import {Car} from './car.model';

@Component({
	selector:"car-list",
	templateUrl:"carlist.component.html",
	styleUrls:["carlist.component.css"]
})
export class CarList {
	carList:Car[] = [];
	
	constructor(private _carService:CarService) {
		this.carList = this._carService.getCarList();
	}

	getCars() {
		this.carList = this._carService.getCarList();
	}
	
	removeCar(idx) {
		this._carService.removeFromCarList(idx);
		this.getCars();
	}
}