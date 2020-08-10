import { Component, Inject, OnInit, Input, Directive, EventEmitter, Output, QueryList, ViewChildren } from '@angular/core';
import { SessionStorageService } from 'angular-web-storage';
import {FormCompComponent} from '../form-comp/form-comp.component';
import { MatDialog, MatDialogConfig } from "@angular/material/dialog";
import { CommonService } from '../common.service';


@Component({
  selector: 'app-table-comp',
  templateUrl: './table-comp.component.html',
  styleUrls: ['./table-comp.component.scss']
})

export class TableCompComponent implements OnInit {

  public a = [];
  public elements: any = [];
  deleteArr: any = [];
  headElements = ['Emp Id', 'First Name', 'Last Name', 'Age', 'City', 'Edit', 'Delete'];
  @Input() childData: [];

  constructor(private service: CommonService,
    private session: SessionStorageService, 
    // private formCompComponent: FormCompComponent,
    private dialog: MatDialog) { }
  // constructor(private session: SessionStorageService, private confirmationPopoverModule: ConfirmationPopoverModule) { }

  ngOnInit(): void {
    this.service.getFromSession();
    this.elements = this.service.elements;
  }

  deleteFromSession(id: any) {
    if (confirm('Are you sure you want to delete?')) {
      alert("Record Deleted.");
      console.log(id);
      this.deleteArr.push(this.elements[id]);
      for( var i = 0; i < this.elements.length; i++)
      { if ( this.elements[i].empId === id) 
        { this.elements.splice(i, 1); }
      }
      console.log('Record deleted.');
      console.log(this.elements);
      this.session.set("DataArr", JSON.stringify(this.elements));
    } else {
      alert("Deletion cancelled.");
      console.log('Record not deleted.');
    }
    
  }

  editRecord(el: any): void{
    console.log("Edit Record");
    console.log(el);
    this.service.populateForm(el);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "60%";
    this.dialog.open(FormCompComponent, dialogConfig);
  }

  openDialog(): void {
    console.log("open dialog");
    this.service.initializeFormGroup();
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "60%";
    this.dialog.open(FormCompComponent, dialogConfig);
  }

  resetTable(): void{
    this.session.clear();
    console.log("called reset table");
    // console.log((<HTMLInputElement>document.getElementById("tablebody")).remove());
    this.session.set("DataArr", JSON.stringify(this.childData));
    this.elements = this.childData;
    console.log(this.elements);
  } 

  sortTable(n): void {
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("myTable");
    switching = true;
    dir = "asc";
    while (switching) {
      switching = false;
      rows = table.rows;
      for (i = 1; i < (rows.length - 1); i++) {
        shouldSwitch = false;
        x = rows[i].getElementsByTagName("TD")[n];
        y = rows[i + 1].getElementsByTagName("TD")[n];
        if (dir == "asc") {
          if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
            shouldSwitch= true;
            break;
          }
        } else if (dir == "desc") {
          if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
            shouldSwitch = true;
            break;
          }
        }
      }
      if (shouldSwitch) {
        rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
        switching = true;
        switchcount ++;      
      } else {
        if (switchcount == 0 && dir == "asc") {
          dir = "desc";
          switching = true;
        }
      }
    }
  }

}

