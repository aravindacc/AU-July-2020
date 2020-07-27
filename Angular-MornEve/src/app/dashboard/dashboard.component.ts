import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {CommonService} from '../common.service';
import { ArrayType } from '@angular/compiler';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  constructor(private cSvc: CommonService) { }
  @Input()
  num: number;
  elm: string;

  @Output() new1 = new EventEmitter<string>(); 


  ngOnInit(): void {
    console.log('dashboard', this.num);
    this.cSvc.log();
  }

  emit(){
    this.new1.emit(this.elm);
  }

}
