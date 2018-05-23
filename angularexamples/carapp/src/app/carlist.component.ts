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
		console.log("On getCars()");
		this._carService.getCarList().subscribe(
			datalist => this.carList = datalist,
			error => console.log("error in getCars:"+error),
			() => console.log("getCars Completed")
		);
	}
	
	removeCar(index) {
		this._carService.removeCar(index).subscribe(
		data => { console.log("Success in removeCar:"+data);
				  this.getCars();},
		error => console.log("Error in removeCar:"+error),
		() => console.log("removeCar completed")
		
		);
	}
}