import {Component} from '@angular/core';
import {LoginService} from './loginservice.service';

@Component({
	selector:"login-form",
	templateUrl:"loginform.component.html"
})
export class LoginForm {

	username:string ="";
	password:string ="";
	constructor(private _loginService:LoginService) {
	}

	login() {
		this._loginService.login();
	}
	
	
}