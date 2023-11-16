import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {AppRouter} from './app-router';
import {FormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRouter,
    FormsModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
