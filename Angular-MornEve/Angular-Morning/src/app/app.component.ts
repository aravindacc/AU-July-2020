import { Component, OnChanges, OnInit, Inject } from '@angular/core';
import { CommonService } from './common.service';
import { SessionStorageService } from 'angular-web-storage';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnChanges, OnInit{
  title = 'Angular-Morning';
  num = 1;

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

  constructor(private session: SessionStorageService, private service: CommonService,) { }

  ngOnChanges(){
  }

  ngOnInit(): void{
    console.log("entered");
    console.log(this.data);
    
    this.saveInSession(this.data);
    this.service.addInSession(this.data1);

  }

  log(str:string):void{
    console.log('clicked' + str);
  }

  saveInSession(data): void {
    console.log("called session");
    console.log('saved= ' + JSON.stringify(data));
    this.session.set("DataArr", JSON.stringify(data));
  }
 }

