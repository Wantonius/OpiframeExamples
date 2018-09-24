import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { HelloWorld} from './helloworld.component';
import {PersonList} from'./personlist.component';
import {ShowThis} from './showthis.component';
@NgModule({
  declarations: [
    AppComponent,
	HelloWorld,
	PersonList,
	ShowThis
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
