import React, { useState, useEffect } from "react";
import { Text, TextInput, View, StyleSheet, Button, AsyncStorage, ImageBackground, TouchableOpacity,Alert } from "react-native";
import { add } from "react-native-reanimated";
import ShowList from './ShowList';



const ToDo= ({navigation}) =>{
    const [todoList, settodoList] = useState("");
    const [display,setDisplay] = useState("");
  
    useEffect(() => {
        checkTodo()
    }, [])

    const checkTodo = async () => {
        const list = await AsyncStorage.getItem("todoList");
        if (list) {
            setDisplay(list);
        }
        
    }
   

        const createTwoButtonAlert = () =>
        Alert.alert(
            'Adding To Do',
            'Are you sure you want to add?',
            [
              {
                text: 'Ask me later',
                onPress: () => console.log('Ask me later pressed')
              },
              {
                text: 'Cancel',
                onPress: () => console.log('Cancel Pressed'),
                style: 'cancel'
              },
              { text: 'OK', onPress: () => console.log('OK Pressed') }
            ],
            { cancelable: false }
          );

        
    const addTodo = async () => {
        
        
      
        try {
            const myArray = await AsyncStorage.getItem('todoList');

            if (myArray == null) {
             
              var obj = [];
              obj.push(todoList);
              await AsyncStorage.setItem('todoList', JSON.stringify(obj));
              await useEffect(() => {
                checkTodo()
              }, [])
             
            }
            else{
                var arr = JSON.parse(myArray);
                
               arr.push(todoList);
                await AsyncStorage.setItem('todoList', JSON.stringify(arr));
                await useEffect(() => {
                    checkTodo()
                  }, [])
                
                  
            }
          } catch (error) {
          }
        }
          
          const deleteTodo = async () => {
        
             try {
                 const myArray = await AsyncStorage.getItem('todoList');
                 var newArr = await JSON.parse(myArray);
              
                 var index = await newArr.indexOf(todoList);
                 if(index == -1){
                     return;
                 }
                 await newArr.splice(index, 1);
                 await AsyncStorage.setItem('todoList', JSON.stringify(newArr));
                 await useEffect(() => {
                    checkTodo()
                  }, [])
                 
               } catch (error) {
                 
                 console.log(error);
               }
            }
               


    
    return (
        <View  style={{width:300,    marginTop: 100,
          marginRight: 'auto',
          marginBottom: 0,
          marginLeft: 'auto'}}>
            
            <TextInput style={{margin:20}} onChangeText={(todo) => settodoList(todo)} placeholder="Enter Todo List" />
            <Button  style={{margin:20}} color="blue" title="Set Todo" onPress={
                () => { addTodo(); createTwoButtonAlert(); }
                }/>
            
            <Text  style={{margin:20}} >{display}</Text>
            <Text  style={{margin:20}} >Reload to see changes in todos</Text>
            <TextInput  style={{margin:20}} onChangeText={(todo) => settodoList(todo)} placeholder="Enter todo to delete." />
         
            <Button  style={{margin:20}} color="orange" title="Delete Todo"   onPress={
                () => { deleteTodo(); createTwoButtonAlert();}
                } /> 

           
        </View>
       

    )  


              }
  
const Styles = StyleSheet.create({
    title: {
        fontSize: 16,
        color: "white",
        fontWeight: "700",
        padding: 5,
        width:"600px"
    },
    source: {
        fontSize: 16,
        color: "white",
        fontWeight: "700",
        padding: 5,
        alignSelf: "flex-end"
    },
    background: {
     
        justifyContent: "space-between"
    },
    container: {
     
        height: 150,
        marginLeft: "2.5%",
        marginRight: "2.5%",
        marginVertical: 5,
        width:"300px"
    },
    textInputStyle: {
        borderColor: "black",
        borderWidth: 1,
        borderRadius: 5,
        fontSize: 20,
        padding: 5,
        width: "100%",
        marginBottom: 20
    },    ButtonStyle: {
    
      width: "300px"
     
  }

})

export default ToDo;