import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { CarShop } from './carshop.component';
import { CarService} from './carservice.service';

@NgModule({
  declarations: [
    AppComponent,
	CarShop
  ],
  imports: [
    BrowserModule,
	FormsModule
  ],
  providers: [CarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
