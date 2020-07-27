  
import { Component,OnInit} from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  title = 'Angular-Afternoon-Assignment';
  newUser = {firstname:'',lastname:'',age:"",empId:'',city:''};
  user1 = {firstname:'Neeraj ',lastname:'Solanki',age:"26",empId:'INT444',city:'Bangalore'};
  user2 = {firstname:'Kuldeep',lastname:'Solanki',age:"24",empId:'INT426',city:'Bangalore'};
  name = [this.user1,this.user2];
  delkey = null;

  ngOnInit(){ 

  }
 
   
  addUser = () =>{
      let temp = {firstname:'',lastname:'',age:"",empId:'',city:''};
      temp.firstname = this.newUser.firstname;
      temp.lastname = this.newUser.lastname;
      temp.age = this.newUser.age;
      temp.empId = this.newUser.empId;
      temp.city = this.newUser.city;
      
      this.name.push(temp);
     // newUser = {first:'',last:'',age:"",empId:'',city:''};
      return ;
  } 
  
  sortUser1 = () =>{
     this.name.sort((a,b) => a.firstname.localeCompare(b.firstname));
     return ;
  }
  sortUser2 = () =>{
    this.name.sort((a,b) => a.lastname.localeCompare(b.lastname));
    return ;
 }
 sortUser3 = () =>{
  this.name.sort((a,b) => a.age.localeCompare(b.age));
  return ;
}
sortUser4 = () =>{
  this.name.sort((a,b) => a.empId.localeCompare(b.empId));
  return ;
}
sortUser5 = () =>{
  this.name.sort((a,b) => a.city.localeCompare(b.city));
  return ;
}

updateUser= () =>{
  let temp = {firstname:'',lastname:'',age:"",empId:'',city:''};
      temp.firstname = this.newUser.firstname;
      temp.lastname = this.newUser.lastname;
      temp.age = this.newUser.age;
      temp.empId = this.newUser.empId;
      temp.city = this.newUser.city;
  var num : Number = null;
  for(var i=0;i<this.name.length;i++){
    var obj = this.name[i];
    if(obj.empId == this.newUser.empId){
      this.name[i] = temp;
      break;
    }
  }
  
  
}

deleteUser=()=>{
  
  
  for(var i=0;i<this.name.length;i++){
    var obj = this.name[i];
    if(obj.empId == this.delkey){
      this.name.splice(i,1);
      break;
    }
  }
}

    
    
   username : 'Neeraj';


}