import React, { useEffect, useState } from 'react';
import { Text, TextInput, View, Button, SafeAreaView, Platform, StyleSheet, ActivityIndicator, FlatList, AsyncStorage, Appbar } from 'react-native';

export default function Dashboard(props) {
    const [note, setNote] = useState([]);
    const [allNote, setAllNote] = useState([]);

    useEffect(() => {
        fetchData();
    }, [note]);

    const fetchData = async () => {
        const notes = await AsyncStorage.getItem('note');
        if(!notes) await AsyncStorage.setItem('note', JSON.stringify([]));
        const arr = JSON.parse(notes);
        setAllNote(arr);
        
    }

    const handleDelete = async (item) => {
        await AsyncStorage.clear();
        setAllNote([]);
    };

    const logout = async () => {
        await AsyncStorage.clear();
        props.navigation.navigate("Login");
    }

    const addTodo = async () => {
        const arrNote = await AsyncStorage.getItem('note') ;
        const arr = JSON.parse(arrNote);
        arr.push(note);
        await AsyncStorage.setItem("note", JSON.stringify(arr));
    };

    return (
        <View style={styles.container}>
            <Button title="Logout" onPress={logout}>
            </Button>
            
            <TextInput
                style={styles.textInputStyle}
                onChangeText={(note) => setNote(note)}
                placeholder="Write your todo" />
            <View style={styles.containerButton}>
                <Button title="Add" onPress={addTodo} />
                <Button title="Delete" onPress={handleDelete} />
            </View>
            {allNote && allNote.length > 0 && 
            allNote.map(item => <Text>{item}</Text>)} 
            
        </View>
    );
}


const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center"
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
    containerButton: {
        flexDirection: 'row',
        justifyContent: 'space-between'
    }
})