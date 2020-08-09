import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  ADD_PRODUCT = "/com.maven.webapp/item/add";
  GET_ALL = "/com.maven.webapp/item/getAll";
  GET_TOP_TEN = "/com.maven.webapp/item/getTopTen";
  DELETE_PRODUCT = "/com.maven.webapp/item/delete/";
  SEARCH_PRODUCT = "/com.maven.webapp/item/search/";

  constructor(private http: HttpClient) { }

  addProduct(payload: any) {
    return this.http.post(this.ADD_PRODUCT, payload);
  }


  getAllProduct()
  {
    return this.http.get(this.GET_ALL);
  }

  
  getTopTen()
  {
    return this.http.get(this.GET_TOP_TEN);
  }
  
  getSearchProduct(nameOrCategory:string)
  {
    return this.http.get(this.SEARCH_PRODUCT+nameOrCategory);
  }

  deleteProduct(id:number)
  {
    return this.http.get(this.DELETE_PRODUCT+id)
  }
}
