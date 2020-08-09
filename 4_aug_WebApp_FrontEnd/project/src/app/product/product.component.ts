import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { FormGroup, Validators, FormControl } from '@angular/forms';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {

  @Output() addProductToDatabase: EventEmitter<any> = new EventEmitter<any>();
  addProductForm: FormGroup;

  constructor() { }

  ngOnInit(): void {
    this.buildForm();
  }

  buildForm() {
    this.addProductForm = new FormGroup({
      name: new FormControl('', [Validators.required, Validators.pattern('[a-zA-z ]*')]),
      description: new FormControl('', [Validators.required, Validators.pattern('[a-zA-z ]*'), Validators.maxLength(250)]),
      category: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(15)]),
      imageUrl: new FormControl('', [Validators.required, Validators.pattern('http[s]?://.*')]),
      price: new FormControl('', [Validators.required, Validators.pattern('[0-9]{1,10}')]),
    });
  }

  addProductProductComponent() {
    this.addProductToDatabase.emit(this.addProductForm.value);
    this.addProductForm.reset();
  }

}
