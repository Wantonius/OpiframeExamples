import {Injectable} from '@angular/core';
import {Car} from './car.model';

@Injectable()
export class CarService {
	carList:Car[] = [];

	getCarList() {
		return this.carList;
	}
	
	addToCarList(car:Car) {
		this.carList.push(car);
	}
	
	removeFromCarList(idx:number) {
		this.carList.splice(idx,1);
	}
}
