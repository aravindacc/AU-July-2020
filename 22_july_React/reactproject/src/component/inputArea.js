import React,{useState} from "react";

import       { addItem } from "./storage"
const  InputArea =(props)=>{

      const [item,setItem] = useState("");
      const add =(t)=>{
            if(item !== ""){
                  addItem(item);
                  props.load();
                  setItem("");      
            }else
                  alert("Please, insert item to add in Todo!");

      }

      
      return (
            <div className="row p-3 border" style={{width:"80%", justifyContent:"center"}}>       
            <h5  >Todo Input</h5>         

                  <div className="" style={{width:"100%"}} >                   
                     <input type="text" className="form-control" value={item} onChange={(t)=>setItem(t.target.value) } placeholder="Enter Todo item"></input>                           
                     <button type="submit" className="btn btn-md btn-block btn-success mt-2" onClick={add} >Add Item</button>
                  </div>
            </div>);
}

export default  InputArea