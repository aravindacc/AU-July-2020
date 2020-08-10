import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import * as dMaterial from "@angular/material/dialog";
import * as tMaterial from "@angular/material/table";
import * as bMaterial from "@angular/material/button";
import * as sMaterial from "@angular/material/select";
import * as iMaterial from "@angular/material/input";
import * as fMaterial from "@angular/material/form-field";
import * as tbMaterial from "@angular/material/toolbar";
import * as gMaterial from "@angular/material/grid-list";


@NgModule({
  imports: [
    CommonModule,
    tbMaterial.MatToolbarModule,
    fMaterial.MatFormFieldModule,
    gMaterial.MatGridList,
    iMaterial.MatInputModule,
    sMaterial.MatSelectModule,
    bMaterial.MatButtonModule,
    tMaterial.MatTableModule,
    dMaterial.MatDialogModule,

  ],
  exports: [
    tbMaterial.MatToolbarModule,
    fMaterial.MatFormFieldModule,
    gMaterial.MatGridList,
    iMaterial.MatInputModule,
    sMaterial.MatSelectModule,
    bMaterial.MatButtonModule,
    tMaterial.MatTableModule,
    dMaterial.MatDialogModule,

  ],
  declarations: []
})
export class MaterialModule { }