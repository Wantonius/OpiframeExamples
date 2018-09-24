import { Component, OnInit } from '@angular/core';
import { LoginService} from './loginservice.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  isLogged:boolean = false;
  
  constructor(private _loginService:LoginService) {
	  _loginService.logIn$.subscribe(
		() => this.isLogged = true,
		(error) => console.log(error),
		() => console.log("logIn is Complete")
	  );
	  _loginService.logOut$.subscribe(
		() => this.isLogged = false,
		(error) => console.log(error),
		() => console.log("Logout is Complete")
	  );
  }
 
  ngOnInit() {
	  this.isLogged = this._loginService.isLogged();
  }
  
  logout() {
	  this._loginService.logout();
  }

}
