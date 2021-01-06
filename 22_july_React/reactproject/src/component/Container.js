import React, { useContext,useEffect,useState  } from 'react';
import {ThemeContext} from './MyContext';
import InputArea from './inputArea'
import './../App.css';
import OutputArea from './OutputArea';
import { getAllItem } from "./storage";

const Container = (props)=>
{
      const theme = useContext(ThemeContext);
      const [items, setItems] = useState([]);
      
      useEffect(()=>{
            load();
      },[])

      const load = ()=>{
            setItems(getAllItem());
      }

      return (
    <div className="App">
      <div className="App-header" style={ {backgroundColor:theme.bg, color:theme.fg} }> 
            <button className="ThemeButton btn btn-sm" onClick={props.changeTheme} >Change Theme</button>
            <InputArea load={load}/>
            <OutputArea items={items} load={load}/> 
      </div>
      </div>
      );
};


export default Container;