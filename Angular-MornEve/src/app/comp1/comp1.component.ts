import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-comp1',
  templateUrl: './comp1.component.html',
  styleUrls: ['./comp1.component.scss']
})
export class Comp1Component implements OnInit {

  constructor() { }

  profileForm = new FormGroup({
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    street: new FormControl(''),
    city: new FormControl('')
  });

  paymentForm = new FormGroup({
    ccNumber: new FormControl(''),
    cvv: new FormControl(''),
    name: new FormControl(''),
    expDate: new FormControl('')
  });

  ngOnInit(): void {
  }

  onSubmit() {
    // TODO: Use EventEmitter with form value
    console.warn(this.profileForm.value);
    console.warn(this.paymentForm.value);
  }

}