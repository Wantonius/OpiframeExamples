import {Component} from '@angular/core';
import {Car} from './car.model';
import {CarService} from './carservice.service';

@Component({
	selector:"carshop",
	templateUrl:"carshop.component.html"
})
export class CarShop {
	carList:Car[];
	car:Car;
	
	constructor(private _carService:CarService) {
		this.getCars();
		this.car = new Car("",0);
	}

	getCars() {
		this.carList = this._carService.getCarList();
	}
	
	addCar() {
		this._carService.addToCarList(this.car);
		this.car = new Car("",0);
		this.getCars();
	}
	
	removeCar(idx:number) {
		this._carService.removeFromCarList(idx);
		this.getCars();
	}
}