import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CommonService {
  num = 1;
  constructor() { }

  log(){
    console.log("common service" + this.num++);
  }
}
