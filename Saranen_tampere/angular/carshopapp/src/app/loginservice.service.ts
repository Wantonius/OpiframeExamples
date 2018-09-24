import {Injectable} from '@angular/core';
import {Subject} from 'rxjs';
import {Router} from '@angular/router'

@Injectable()
export class LoginService {
	loginState:boolean = false;
	token:string = "";
	private loggedIn = new Subject<string>();
	private loggedOut = new Subject<string>();
	
	logIn$ = this.loggedIn.asObservable();
	logOut$ = this.loggedOut.asObservable();
	constructor(private _router:Router) {
	
	}
	
	login() {
		this.loginState=true;
		this.loggedIn.next("");
		this._router.navigate(["/CarList"]);
	}
	
	logout() {
		this.loginState=false;
		this.loggedOut.next("");
		this._router.navigate(["/Login"]);
	}
	
	isLogged() {
		return this.loginState;
	}
	
	setToken(t:string) {
		this.token = t;
	}
	
	getToken() {
		return this.token;
	}

}