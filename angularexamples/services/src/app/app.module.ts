import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';

import {CarList} from './carlist.component';
import { AppComponent } from './app.component';
import {CarService} from './car.service';

@NgModule({
  declarations: [
    AppComponent,
	CarList
  ],
  imports: [
    BrowserModule,
	FormsModule
  ],
  providers: [CarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
