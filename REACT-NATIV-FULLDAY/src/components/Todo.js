import React, { useEffect, useState } from "react";
import {
  Text,
  SafeAreaView,
  Platform,
  StyleSheet,
  FlatList,
  TextInput,
  Button,
  TouchableOpacity,
  View,
  navigation,
  AsyncStorage
} from "react-native";

import Lists from "./Lists";
import Login from "./Login";

export default function Todo(props) {
  const [value, setValue] = useState({
    id: "",
    content: ""
  });
  const [items, setItems] = useState([]);

  function fun(text) {
    const hashCode = Math.random()
      .toString(20)
      .substr(2, 6);
    setValue({
      id: hashCode,
      content: text
    });
  }
  const fresh = async () => {
    setItems(prev => {
      return [...prev, value];
    });
    var obj = [];
    obj.push(items);
   
    
    await AsyncStorage.setItem("items", JSON.stringify(obj));
    setValue({ content: "" });
    alert("New todo added");
  };
  const deletee = e => {
    setItems(items.filter(item => item.id !== e));
  };
  const Logout = async () => {
    navigation.navigate("Login");
    AsyncStorage.clear();

  };
  const display = async () => {
    var x= JSON.parse( await AsyncStorage.getItem("items").then());
   return x;
  };
  return (
    <SafeAreaView>
      <TextInput
        style={Styles.textInputStyle}
        placeholder="Please enter your todo..."
        onChangeText={text => fun(text)}
        value={value.content}
      />
      <Button title="Logout" onPress={Logout} />
      <Button title="ADD" onPress={fresh} />

     {/* <Text>{display()[0].id}</Text> */}
      <FlatList
        data={items}
        renderItem={({ item }) => (
          <View>
            <Lists data={item.content} />

            <TouchableOpacity onPress={() => deletee(item.id)}>
              <View style={Styles.container}>
              
                <Text style={Styles.source}>Remove</Text>
              </View>
            </TouchableOpacity>
          </View>
        )}
        keyExtractor={item => item.id}
        initialNumToRender={5}
      />
    </SafeAreaView>
  );
}

const Styles = StyleSheet.create({
  mainContainer: {
    marginTop: Platform.OS === "android" ? 25 : 0
  },
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "#F5FCFF"
  },
  textInputStyle: {
    borderColor: "black",
    borderWidth: 1,
    borderRadius: 5,
    fontSize: 20,
    padding: 5,
    width: "60%",
    marginBottom: 20
  },
  source: {
    borderRadius: 2,

    // Set border width.
    borderWidth: 2,

    // Set border Hex Color Code Here.
    borderColor: "#363636",

    // Setting up Text Font Color.
    color: "#fff",

    // Setting Up Background Color of Text component.
    backgroundColor: "#ff5f40",

    // Adding padding on Text component.
    padding: 2,

    fontSize: 20,

    textAlign: "center",
    width: 80,
    justifyContent: "center",

    margin: 2
  }
});
