import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss']
})
export class HomepageComponent implements OnInit {

  constructor(private productService:ProductService) { }

  listOfItem:object;

  ngOnInit(): void {
    this.getTopTenItem();
  }

  getTopTenItem()
  {
    this.productService.getTopTen().subscribe((response)=>{
      console.log(response)
        this.listOfItem = response;
    },
    (err)=>{
      alert(err);
    });
  }

  loadAfterDelete($event)
  {
    this.getTopTenItem();
  }
}
