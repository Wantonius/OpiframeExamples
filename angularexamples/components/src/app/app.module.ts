import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { DataList} from './datalist.component';
import { MaybeShown } from './showtest.component';
@NgModule({
  declarations: [
    AppComponent,
	DataList,
	MaybeShown
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
