import { Component, OnChanges, OnInit, Inject } from '@angular/core';
import { CommonService } from './common.service';
// import {SESSION_STORAGE, WebStorageService} from 'angular-webstorage-service';
import { SessionStorageService } from 'angular-web-storage';
import { TableCompComponent } from './table-comp/table-comp.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnChanges, OnInit{
  title = 'Angular-Morning';
  num = 1;
  // showDB:boolean;
  // isHL: boolean;

  // obj = {a: 1};

  // arr = [
  //   {
  //     id: 1,
  //     title: 'a'
  //   },
  //   {
  //     id: 2,
  //     title: 'b'
  //   },
  //   {
  //     id: 3,
  //     title: 'c'
  //   }

  // ];

  public data = [
    {
      empId: 1,
      firstName: 'a',
      lastName: 'b',
      age: 23,
      city: 'hyd'
    },
    {
      empId: 2,
      firstName: 'b',
      lastName: 'd',
      age: 24,
      city: 'bng'
    }
  ]

  public data1 = {
    empId: 3,
    firstName: 'g',
    lastName: 'b',
    age: 23,
    city: 'hyd'
  }

  // constructor(private cSvc: CommonService) {}

  // constructor(@Inject(SESSION_STORAGE) private storage: WebStorageService) {}
  constructor(private session: SessionStorageService) { }

  ngOnChanges(){
    // const title = '1';
    // this.title = title;
  }

  ngOnInit(): void{
    // this.showDB = true;
    // this.cSvc.log();
    console.log(this.data);
    console.log("entered");
    this.saveInSession(this.data);
    this.addInSession(this.data1);
    // this.getFromSession();

  }

  log(str:string):void{
    console.log('clicked' + str);
  }

  saveInSession(data): void {
    console.log("called session");
    console.log('saved= ' + JSON.stringify(data));
    this.session.set("DataArr", JSON.stringify(data));
  }

  addInSession(data1): void {
    console.log("add in session");
    var a = [];
    a = JSON.parse(this.session.get('DataArr')) || [];
    a.push(this.data1);
    // alert(a);
    this.session.set('DataArr', JSON.stringify(a));
  }
  
  // toggle(){
  //   this.showDB = !this.showDB;
  // }

  // toggleHL(){
  //   this.isHL = !this.isHL;
  // }
 }

