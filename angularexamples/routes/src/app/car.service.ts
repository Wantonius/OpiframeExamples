import {Car} from './car.model';
import {Injectable} from '@angular/core';

@Injectable()
export class CarService {

	carList:Car[] = [
		{type:"Ford",price:2000},
		{type:"Audi",price:8000},
		{type:"Volkswagen",price:1000}
	]
	
	getCarList() {
		return this.carList;
	}
	
	addCar(car) {
		this.carList.push(car);
	}
	
	removeCar(index) {
		this.carList.splice(index,1);
	}
}