import React, { useState, useContext } from "react";
import { deleteItem, editItem } from "./storage"
import editIcon from './image/edit.png'
import deleteIcon from './image/delete.png'
import yesIcon from './image/yes.png'
import noIcon from './image/no.png'
import { ThemeContext } from "./MyContext";

const  Item =(props)=>{
      const [edittable, setEditable] = useState(false);
      const [editableitem, setEditableItem] = useState(props.text); 
      const theme = useContext(ThemeContext);
      
      
      const edit =()=>{
            setEditable(!edittable);
      }

      const save = ()=>{
            if(editableitem !== ""){
                  editItem(props.keyId,editableitem);
                  edit();
                  props.load();
            }else 
                  alert("Item can't be blank!");
      }

      const cancel  = ()=>{
            setEditableItem(props.text);
            edit();
      }
   
      const delete_item = ()=>{
            
            deleteItem(props.keyId);
            props.load();
      }

      return (  
      <div>         
            <div className="d-flex small border mt-1  p-1">                 
                        <input type="text" disabled={!edittable} onChange={(t)=>setEditableItem(t.target.value)} 
                        style={{color:theme.fg}} className="p-0 px-4 mr-auto w-100 item" value={editableitem}/>
                        <button className="btn ml-2 btn-sm" onClick={edit} hidden={edittable} ><img src={editIcon} className="icon" alt="Edit"></img></button>
                        <button className="btn ml-2 btn-sm" onClick={save} hidden={!edittable} ><img src={yesIcon} className="icon" alt="Edit"></img></button>
                        <button className="btn ml-2 btn-sm" onClick={cancel} hidden={!edittable} ><img src={noIcon} className="icon" alt="Edit"></img></button>
                        <button className="btn  ml-2 btn-sm" onClick={delete_item} ><img src={deleteIcon} className="icon" alt="Delete"></img></button>
                  
            </div>
      </div>
      );

}

export default  Item