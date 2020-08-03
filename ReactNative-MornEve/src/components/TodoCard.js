import React from "react";
import { View } from "react-native";

const TodoCard = (props) => {
    return (
        <View style={{margin:10}}>
            <Text>{props.note}</Text>
        </View>);
}

export default TodoCard;