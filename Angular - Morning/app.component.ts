import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  
  title = "Angular Morning Assingment";

   supermarket: any={} =[
    {
      id: 1,
      title: "flower"
    },
    {
      id:2,
      title:"chocolate"
    },
    {
      id: 3,
      title: "aloe vera"
    },
    {
      id:4,
      title:"fruits"
    },
    {
      id: 5,
      title: "surf excel"
    },
    {
      id:6,
      title:"tshirt"
    },
    {
      id: 7,
      title: "pant"
    },
    {
      id:8,
      title:"sweater"
    },
    {
      id: 9,
      title: "shorts"
    },
    {
      id:10,
      title:"bottles"
    },
    {
      id: 11,
      title: "mobiles"
    },
    {
      id:12,
      title:"headphones"
    }
  ]

  ngOnInit():void{
    console.log("app class")
  }
  
}
