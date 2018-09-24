import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { RouterModule, Routes} from '@angular/router';

import {CarService} from './carservice.service';
import {CarList} from './carlist.component';
import {CarForm} from './carform.component';

import { AppComponent } from './app.component';

const appRoutes:Routes = [
		{path:'', redirectTo:'CarList',pathMatch:'full'},
		{path:"CarList",component:CarList},
		{path:"CarForm",component:CarForm}
]

@NgModule({
  declarations: [
    AppComponent,
	CarList,
	CarForm
  ],
  imports: [
    BrowserModule,
	FormsModule,
	RouterModule.forRoot(appRoutes)
  ],
  providers: [CarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
