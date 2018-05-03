import {Car} from './car.model';
import {Injectable} from '@angular/core';
import {Http,Headers,Response} from '@angular/http';
import 'rxjs/add/operator/map';


@Injectable()
export class CarService {
	carList:Car[] = [
		{type:"Ford",price:2000},
		{type:"Audi",price:8000},
		{type:"Volkswagen",price:1000}
	]
	
	constructor(private _http:Http) {}
	
	getCarList() {
		return this._http.get('/api/data').map(response => response.json());
		
	}
	
	addCar(car) {
		//this.carList.push(car);
		return this._http.post('/api/data',{"type":car.type,
		"price":car.price}).map(response => response.json());
	}
	
	removeCar(index) {
		return this._http.delete('/api/data/'+index).map(response => response.json());
	}
}