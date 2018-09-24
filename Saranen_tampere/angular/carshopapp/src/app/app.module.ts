import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { RouterModule, Routes} from '@angular/router';

import {CarService} from './carservice.service';
import {CarList} from './carlist.component';
import {CarForm} from './carform.component';
import {LoginService} from './loginservice.service';
import {LoginForm} from './loginform.component';

import { AppComponent } from './app.component';

const appRoutes:Routes = [
		{path:'', redirectTo:'Login',pathMatch:'full'},
		{path:"CarList",component:CarList},
		{path:"CarForm",component:CarForm},
		{path:"Login",component:LoginForm}
]

@NgModule({
  declarations: [
    AppComponent,
	CarList,
	CarForm,
	LoginForm
  ],
  imports: [
    BrowserModule,
	FormsModule,
	RouterModule.forRoot(appRoutes)
  ],
  providers: [CarService,
			  LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
