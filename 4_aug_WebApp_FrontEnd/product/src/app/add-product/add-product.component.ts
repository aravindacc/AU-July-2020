import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.scss']
})
export class AddProductComponent implements OnInit {

  constructor(private productService: ProductService) { }
  data:any ;
  ngOnInit(): void {
    this.data = history.state.data;
  }

  addProduct(payload) {
    this.productService.addProduct(payload).subscribe((res)=>
    {
      if(res >= 0)
      {
       alert("product inserted successfully"); 
      }
    });
  }

}
