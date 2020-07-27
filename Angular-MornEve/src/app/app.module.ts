import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
// import { Comp1Component } from './comp1/comp1.component';
// import { Comp2Component } from './comp2/comp2.component';
// import { Comp3Component } from './comp3/comp3.component';
// import { DashboardComponent } from './dashboard/dashboard.component';
import { TableCompComponent } from './table-comp/table-comp.component';
import { ConfirmationPopoverModule } from 'angular-confirmation-popover';
import { FormCompComponent } from './form-comp/form-comp.component';

@NgModule({
  declarations: [
    AppComponent,
    // Comp1Component,
    // Comp2Component,
    // Comp3Component,
    // DashboardComponent,
    TableCompComponent,
    FormCompComponent
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    ConfirmationPopoverModule.forRoot({
      confirmButtonType: 'danger', // set defaults here
    }),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
