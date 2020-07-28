import React, { Suspense} from "react";
import { deleteAllItem } from "./storage"
const Item = React.lazy(()=>import('./Item'));

const  OutputArea =(props)=>{

      props.items.map((item,key)=>console.log(item,key));
      
      const clearItem =()=>{
            deleteAllItem();
            props.load();
      }

      return (
            <div className="row border p-3 m-3" style={{width:"80%", justifyContent:"center"}}>   
            <h5>Todo Item</h5>         
                  <div className="" style={{width:"100%"}} >                     
                  <Suspense fallback={<div>Loading...</div>}>
                   {props.items.map((item,key)=><Item text={item} key={key} keyId={key} load={props.load}/> )}
                   </Suspense>
                   <button type="submit" className="btn btn-md btn-block btn-success mt-2" onClick={clearItem} >Clear Item</button>
                  </div>
            </div>);
}

export default  OutputArea