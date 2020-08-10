import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { TableCompComponent } from './table-comp/table-comp.component';
import { ConfirmationPopoverModule } from 'angular-confirmation-popover';
import { FormCompComponent } from './form-comp/form-comp.component';
import { MatDialogModule } from '@angular/material/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule } from "@angular/material/input";

@NgModule({
  declarations: [
    AppComponent,
    TableCompComponent,
    FormCompComponent
  ],

  imports: [
    BrowserModule,
    ReactiveFormsModule,
    MatDialogModule,
    ConfirmationPopoverModule.forRoot({
      confirmButtonType: 'danger',
    }),
    BrowserAnimationsModule,
    MatInputModule
  ],
  providers: [FormCompComponent],
  bootstrap: [AppComponent],
  entryComponents: [FormCompComponent]
})

export class AppModule { }
