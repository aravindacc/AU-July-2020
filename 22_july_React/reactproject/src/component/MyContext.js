import React, { createContext, useState } from "react";
import Container from "./Container";


import './../css/bootstrap.css';


export const ThemeContext = createContext("");

const MyContext = ()=>{

      const themes = {
            dark : { bg:"#282c34", fg:"#fff"},
            light : {bg:"#fff", fg:"#000"},
      };

      const [theme,setTheme] = useState({
            islight:true,
            name : themes.light
      });

      const toggle = ()=>{        
            setTheme({
                  name: theme.islight?
                  themes.dark:
                  themes.light,
                  islight : !theme.islight
            });
      }
      
      return (<ThemeContext.Provider value={theme.name}>
            <Container changeTheme={()=>toggle()}/>
         
      </ThemeContext.Provider>);

}

export default MyContext;