import React from "react";
import { Text, ImageBackground, TouchableOpacity, StyleSheet, Button } from "react-native";

const Lists = (props) => {
  
    return (
                
                     <Text style={Styles.source}>{props.data}</Text>
                
              
               
      
    );
}

const Styles = StyleSheet.create({
    title: {
        fontSize: 16,
        color: "white",
        fontWeight: "700",
        padding: 5
    },
    source: {
        borderRadius: 5,
 
    // Set border width.
    borderWidth: 2,
 
    // Set border Hex Color Code Here.
    borderColor: '#363636',
 
    // Setting up Text Font Color.
    color: '#fff',
 
    // Setting Up Background Color of Text component.
    backgroundColor : '#99d8d0',
    
    // Adding padding on Text component.
    padding : 2,
 
    fontSize: 20,
 
    textAlign: 'center',
 
    margin: 10
    },
    background: {
        width: "100%",
        height: "100%",
        justifyContent: "space-between"
    },
    container: {
        width: "95%",
        height: 150,
        marginLeft: "2.5%",
        marginRight: "2.5%",
        marginVertical: 5
    }

})

export default Lists;