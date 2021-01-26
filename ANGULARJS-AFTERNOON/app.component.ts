import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
 name="";
  title = 'ANGULAR-AFTERNOON';
  information={fname:"",lname:"",age:"",city:"",id:""}
  newinformation={fname:"",lname:"",age:"",city:"",id:""}
  items=[
{
  fname:"aman",
  lname:"jaiswal",
  age:"24",
  city:"KOLKATA",
  id:"INT430"

},
{
  fname:"Shubham",
  lname:"jaiswal",
  age:"23",
  city:"KOLKATA",
  id:"INT431"

}
  ]
 add() {
  
  if( /^\d+$/.test(this.information.age))
 {

this.items.push(this.information)
sessionStorage.setItem("items",JSON.stringify(this.items))


window.alert("User added")
this.information={fname:"",lname:"",age:"",city:"",id:""}
 }
 else
 {
   alert("age is not valid")
   this.information.age="";
 }
// this.information.fname=""
// this.information.lname=""
// this.information.age=""
// this.information.id=""
//doubt
event.preventDefault();

  }

  // onclick()
  // {
  
  //   console.log(this.name)
  // }
  // fun(x)
  // {
  //   console.log(x)
  //   this.name=x;
  //}
  delete(value)
  {
var x=this.items.length;
this.items=this.items.filter((item)=>item.id!=value)
if(x===this.items.length)
alert("Employ id does not exits")
else
alert("Delted")


  }
  update()
  {

    var flag=false;
    
    for(i=0;i<this.items.length;i++)
    {
if(this.items[i].id===this.newinformation.id)
flag=true;

    }
    if(flag===false)
    alert("Employ id does not exit")

    if( /^\d+$/.test(this.newinformation.age))
    {
  
    for(var i=0;i<this.items.length;i++)
    {
        if(this.items[i].id===this.newinformation.id)
        {
          this.items[i].fname=this.newinformation.fname;
          this.items[i].lname=this.newinformation.lname;
          this.items[i].age=this.newinformation.age;
          this.items[i].city=this.newinformation.city;
        }
    }
    this.newinformation={fname:"",lname:"",age:"",city:"",id:""};
  }
  else{
    alert("Age is not valid");
    this.newinformation.age=""
  }
  }
  sort1()
  {
    this.items.sort((item1,item2)=>{
      return  item1.fname.localeCompare(item2.fname);
    })   
  }
  sort2()
  {
    this.items.sort((item1,item2)=>{
      return  item1.lname.localeCompare(item2.lname);
    })   
  }
  sort3()
  {
    this.items.sort((item1,item2)=>{
      return  item1.city.localeCompare(item2.city);
    })   
  }
  sort4()
  {
    this.items.sort((item1,item2)=>{
      return  item1.age.localeCompare(item2.age);
    })    
  }
  sort5()
  {
    this.items.sort((item1,item2)=>{
      return  item1.id.localeCompare(item2.id);
    })   
  }

}
