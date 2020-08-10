import { Injectable } from '@angular/core';
import { FormControl, Validators, FormBuilder } from "@angular/forms";
import { SessionStorageService } from 'angular-web-storage';

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  public a = [];
  public elements: any = [];
  constructor(private fb: FormBuilder, private session: SessionStorageService,) { }

  form = this.fb.group({
    empId: ['', [Validators.required, Validators.pattern("^[0-9]*$"), Validators.maxLength(2)]],
    firstName: ['',[Validators.required, Validators.pattern("^[a-zA-Z]*$"), Validators.maxLength(20)]],
    lastName: ['', [Validators.required, Validators.pattern("^[a-zA-Z]*$"), Validators.maxLength(20)]],
    age: ['', [Validators.pattern("^[0-9]*$"), Validators.maxLength(2)]],
    city: ['', [Validators.pattern("^[a-zA-Z]*$"), Validators.maxLength(20)]]
  });

  employeeList: any = [];

  initializeFormGroup() {
    this.form.setValue({
      empId: 0,
      firstName: '',
      lastName: '',
      age: 0,
      city: ''
    });
  }

  getEmployees() {
    this.employeeList = this.session.get('DataArr');
    return this.employeeList.snapshotChanges();
  }

  insertEmployee(employee) {
    var a = [];
    // a = JSON.parse(this.session.get('DataArr')) || [];
    // a.push(employee);
    a.push({
      empId: employee.empId,
      firstName: employee.firstName,
      lastName: employee.lastName,
      age: employee.age,
      city: employee.city
    });
    this.session.set("DataArr", JSON.stringify(a));
    this.getFromSession();
  }

  addInSession(employee): void {
    console.log("add in session");
    var a = [];
    a = JSON.parse(this.session.get('DataArr')) || [];
    a.push(employee);
    this.session.set('DataArr', JSON.stringify(a));
  }

  updateEmployee(employee) {
    var a = [];
    a = JSON.parse(this.session.get('DataArr')) || [];
    for (let i = 0; i < a.length; i++) {
      if(employee.empId === a[i].empId){
        a[i].empId = employee.empId, 
        a[i].firstName = employee.firstName, 
        a[i].lastName = employee.lastName, 
        a[i].age = employee.age, 
        a[i].city = employee.city
      }
    }
    
    this.session.set('DataArr', JSON.stringify(a));
    this.getFromSession();
  }

  getFromSession(): void { 
    console.log('printing data from session');
    this.a = JSON.parse(this.session.get('DataArr')) || [];
    console.log(this.a);
    for (let i = 0; i < this.a.length; i++) {
      this.elements.push({ empId: this.a[i].empId, firstName: this.a[i].firstName, lastName: this.a[i].lastName, age: this.a[i].age, city: this.a[i].city });
    }
  }

  populateForm(employee) {
    this.form.setValue(employee);
  }
}
