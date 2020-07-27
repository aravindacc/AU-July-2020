import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
// import { FormCompComponent } from './form-comp/form-comp.component';

@Injectable({
  providedIn: 'root'
})

export class SharedServiceService {

  constructor() { }
  private subject = new Subject<any>();
  sendClickEvent() {
    this.subject.next();
  }
  getClickEvent(): Observable<any>{ 
    return this.subject.asObservable();
  }

  // formCompComponent = new FormCompComponent(null, null, null);
  openForm() {
    document.getElementById("myForm").style.display = "block";
    // this.formCompComponent.onSubmit();
  }
  
  closeForm() {
    document.getElementById("myForm").style.display = "none";
    alert("Addition of record cancelled.");
  }
}
