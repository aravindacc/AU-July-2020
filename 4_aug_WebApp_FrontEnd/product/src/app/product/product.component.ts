import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {

  @Input() data:any;
  @Output() addProductToDatabase: EventEmitter<any> = new EventEmitter<any>();
  addProductForm: FormGroup;
  isUpdateForm:boolean;

  constructor(private productService:ProductService, private router : Router) { }

  ngOnInit(): void {
    
    this.buildForm();
    if(this.data)
    {
      this.addProductForm.get('name').setValue(this.data.name);
      this.addProductForm.get('description').setValue(this.data.description);
      this.addProductForm.get('category').setValue(this.data.category);
      this.addProductForm.get('imageUrl').setValue(this.data.imageUrl);
      this.addProductForm.get('price').setValue(this.data.price);
      this.isUpdateForm = true;
    }else
    {

      this.isUpdateForm = false;
    }
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

  updateProduct()
  {
    let payload = this.addProductForm.value;
    payload["id"]= this.data.id;
    console.log(payload);
    this.productService.updateProduct(payload).subscribe((res)=>{
        this.addProductForm.reset();
        this.router.navigate(['/home']);
    },(err)=>{
      alert(err);
    });  
  }
}
