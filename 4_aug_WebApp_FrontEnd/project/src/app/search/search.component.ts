import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  constructor(private productService:ProductService) { }

  searchText:string = "";
  listOfItem:object;

  ngOnInit(): void {
    this.search();
  }

  callApi()
  {
      if(this.searchText)
      {
          return this.productService.getSearchProduct(this.searchText);
      }else
      {
          return this.productService.getAllProduct();
      }
  }


  search()
  {
    this.callApi().subscribe((response)=>{
      console.log(response)
        this.listOfItem = response;
    },
    (err)=>{
      alert(err);
    });
  }

  loadAfterDelete($event)
  {
    this.search();
  }

}
