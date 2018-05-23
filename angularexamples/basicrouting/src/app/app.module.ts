import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { Home } from './home.component';
import { About } from './about.component';

const appRoutes: Routes = [
   { path: 'Home', component: Home },
   { path: 'About', component: About },
];

@NgModule({
  declarations: [
    AppComponent,
	Home,
	About
	
  ],
  imports: [
    BrowserModule,
	RouterModule.forRoot(appRoutes)	
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
