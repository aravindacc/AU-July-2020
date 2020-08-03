import React, { useState, useEffect } from "react";
import { Text, TextInput, View, StyleSheet, Button, AsyncStorage } from "react-native";


const Login = ({navigation}) =>{
    const [username, setUserName] = useState("");

    useEffect(() => {
        checkAuth()
    }, [])

    const checkAuth = async () => {
        const userName = await AsyncStorage.getItem("username");
        if (userName) {
            navigation.navigate("ToDo");
        }
        return;
    }

    const login = async () => {
        await AsyncStorage.setItem("username", username);
        navigation.navigate("ToDo");
    }

    return (
        <View style={Styles.container}>
      <Text style={Styles.loginTextStyle}>To Do App</Text> 

            <Text style={Styles.loginTextStyle}>Login with your username</Text>
            <TextInput style={Styles.textInputStyle} onChangeText={(text) => setUserName(text)} placeholder="enter your username" />
            <Button color="green" title="Login" onPress={login} />
        </View>
    )
}

const Styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
        marginTop: 0,
         marginRight: 'auto',
         marginBottom: 0,
         marginLeft: 'auto',
    },
    loginTextStyle: {
        fontSize: 20,
        fontWeight: "700",
        marginVertical: 20
    },
    textInputStyle: {
        borderColor: "black",
        borderWidth: 1,
        borderRadius: 5,
        fontSize: 20,
        padding: 5,
        width: "60%",
        marginBottom: 20
    }
})

export default Login;