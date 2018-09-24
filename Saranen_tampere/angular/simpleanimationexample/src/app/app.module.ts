import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MenuContainer} from './menucontainer.component';
import { MyMenu } from './mymenu.component';
@NgModule({
  declarations: [
    AppComponent,
	MenuContainer,
	MyMenu
  ],
  imports: [
    BrowserModule,
	BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
