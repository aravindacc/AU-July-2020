import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {

  constructor(private productService :ProductService, private router : Router) { }

  @Input() listOfItem:object;
  @Output() load = new EventEmitter();

  ngOnInit(): void {
  }

  delete(id:number)
  {
    let flag = confirm("Are you sure?\n You want to delete this item");
    if(flag)
    {
      this.productService.deleteProduct(id).subscribe(
        (res)=>{
          this.load.emit();
        },
        (error)=>  {
          alert(error);
        }
      );
    }
  }

  update(item)
  {
    this.router.navigate(['/updateProduct'],{state: {data :item}});
  }
}
