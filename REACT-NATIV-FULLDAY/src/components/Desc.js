import React from "react";
import { Text } from "react-native";

const Desc = ({ navigation, route }) => {
    console.log(route.params);
    return (
        <Text> description goes here!!!</Text>
    );
}

export default Desc;