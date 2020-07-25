import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ThirdComponent } from './third/third.component';
import { DatasetService  } from './dataset.service'

@NgModule({
  declarations: [
    AppComponent,
    ThirdComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [
    DatasetService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { 
  title = "My-project";
}


