import { Component, OnInit, Input, Directive, EventEmitter, Output, QueryList, ViewChildren } from '@angular/core';
import { SessionStorageService } from 'angular-web-storage';
// import { SharedService } from './../shared.service';
// import { ConfirmationPopoverModule } from 'angular-confirmation-popover'; //'./confirmation-dialog/confirmation-dialog.service';
// import { NgbdTableSortable } from './table-sortable';

// interface elements {
//   empId: number;
//   firstName: string;
//   lastName: string;
//   age: number;
//   city: string;
// }

// export type SortColumn = keyof elements | '';
// export type SortDirection = 'asc' | 'desc' | '';
// const rotate: {[key: string]: SortDirection} = { 'asc': 'desc', 'desc': 'asc' };
// const compare = (v1: string | number, v2: string | number) => v1 < v2 ? -1 : v1 > v2 ? 1 : 0;

// export interface SortEvent {
//   column: SortColumn;
//   direction: SortDirection;
// }

// @Directive({
//   selector: 'th[sortable]',
//   host: {
//     '[class.asc]': 'direction === "asc"',
//     '[class.desc]': 'direction === "desc"',
//     '(click)': 'rotate()'
//   }
// })
// export class NgbdSortableHeader {

//   @Input() sortable: SortColumn = '';
//   @Input() direction: SortDirection = '';
//   @Output() sort = new EventEmitter<SortEvent>();

//   rotate() {
//     this.direction = rotate[this.direction];
//     this.sort.emit({column: this.sortable, direction: this.direction});
//   }
// }

@Component({
  selector: 'app-table-comp',
  templateUrl: './table-comp.component.html',
  styleUrls: ['./table-comp.component.scss']
})

export class TableCompComponent implements OnInit {

  public a = [];
  elements: any = [];
  deleteArr: any = [];
  headElements = ['Emp Id', 'First Name', 'Last Name', 'Age', 'City', 'Edit', 'Delete'];
  @Input() childData: [];

  // countries = COUNTRIES;

  // @ViewChildren(NgbdSortableHeader) headers: QueryList<NgbdSortableHeader>;

  // popoverTitle = 'Popover title';
  // popoverMessage = 'Popover description';
  // confirmClicked = false;
  // cancelClicked = false;

  constructor(private session: SessionStorageService) { }
  // constructor(private session: SessionStorageService, private confirmationPopoverModule: ConfirmationPopoverModule) { }

  ngOnInit(): void {
    console.log("In table oninit");
    this.getFromSession();
  }

  // public openConfirmationDialog(id: any) {
  //   this.confirmationPopoverModule.confirm('Please confirm..', 'Do you really want to ... ?')
  //   .then((confirmed) => {console.log('User confirmed:', confirmed); this.remove(id);})
  //   .catch(() => console.log('User dismissed the dialog (e.g., by using ESC, clicking the cross icon, or clicking outside the dialog)'));
  // }

  // onSort({column, direction}: SortEvent) {

  //   // resetting other headers
  //   this.headers.forEach(header => {
  //     if (header.sortable !== column) {
  //       header.direction = '';
  //     }
  //   });

  //   // sorting countries
  //   if (direction === '' || column === '') {
  //     console.log("hereeeee");
  //     this.elements = this.elements;
  //   } else {
  //     this.elements = [...this.elements].sort((a, b) => {
  //       const res = compare(a[column], b[column]);
  //       return direction === 'asc' ? res : -res;
  //     });
  //   }
  // }

  getFromSession(): void { 
    console.log('printing data from session');
    this.a = JSON.parse(this.session.get('DataArr')) || [];
    console.log(this.a);
    for (let i = 0; i < this.a.length; i++) {
      this.elements.push({ empId: this.a[i].empId, firstName: this.a[i].firstName, lastName: this.a[i].lastName, age: this.a[i].age, city: this.a[i].city });
    }
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

  addInTable(data1): void {
    console.log("add in session");
    var a = [];
    console.log(data1);
    a = JSON.parse(this.session.get('DataArr')) || [];
    // console.log(a);
    a.push(data1);
    this.session.set('DataArr', JSON.stringify(a));
    // add data1 to the new row in the existing table
    // const row = document.getElementById('rowTemplate');
    // const tab = document.getElementById('myTable');
    // console.log(row.innerHTML);
    
    // tab.appendChild(row.cloneNode(data1));
  }

  editRecord(id: any): void{
    console.log("Edit Record");
  }

  resetTable(): void{
    this.session.clear();
    console.log("called reset table");
    // console.log((<HTMLInputElement>document.getElementById("tablebody")).remove());
    this.session.set("DataArr", JSON.stringify(this.childData));
    this.elements = this.childData;
    console.log(this.elements);

    // this.createTable();
    // ("#tablebody").remove();
    // document.getElementById('tablebody').onclick = addMoreFields;    //    set binding

    // var table = <HTMLTableElement>document.getElementById('myTable');
		// var rowCount = table.rows.length;
    // var row = table.insertRow();
      
    // var newRow = document.getElementById('rowTemplate').cloneNode(this.elements),
    //     myTable = document.getElementById('myTable');
    // myTable.appendChild(newRow.cloneNode(this.elements));
    // function addMoreFields() {
    //     myTable.appendChild(newRow.cloneNode(true));
    // }
  } 


  // createTable(): void{
  //   let table = document.getElementById('table');
  //   for (let row of this.childData) {
  //     table.insertRow();
  //     for (let cell of row) {
  //       console.log(row);
  //       // let newCell = table.rows[table.rows.length - 1].insertCell();
  //       // newCell.textContent = cell;
  //     }

  //   }
  //   document.body.appendChild(table);
  // }

  sortTable(n): void {
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("myTable");
    switching = true;
    //Set the sorting direction to ascending:
    dir = "asc"; 
    /*Make a loop that will continue until
    no switching has been done:*/
    while (switching) {
      //start by saying: no switching is done:
      switching = false;
      rows = table.rows;
      /*Loop through all table rows (except the
      first, which contains table headers):*/
      for (i = 1; i < (rows.length - 1); i++) {
        //start by saying there should be no switching:
        shouldSwitch = false;
        /*Get the two elements you want to compare,
        one from current row and one from the next:*/
        x = rows[i].getElementsByTagName("TD")[n];
        y = rows[i + 1].getElementsByTagName("TD")[n];
        /*check if the two rows should switch place,
        based on the direction, asc or desc:*/
        if (dir == "asc") {
          if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
            //if so, mark as a switch and break the loop:
            shouldSwitch= true;
            break;
          }
        } else if (dir == "desc") {
          if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
            //if so, mark as a switch and break the loop:
            shouldSwitch = true;
            break;
          }
        }
      }
      if (shouldSwitch) {
        /*If a switch has been marked, make the switch
        and mark that a switch has been done:*/
        rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
        switching = true;
        //Each time a switch is done, increase this count by 1:
        switchcount ++;      
      } else {
        /*If no switching has been done AND the direction is "asc",
        set the direction to "desc" and run the while loop again.*/
        if (switchcount == 0 && dir == "asc") {
          dir = "desc";
          switching = true;
        }
      }
    }
  }

}

