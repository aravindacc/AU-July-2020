import React from "react";
import { createStackNavigator } from '@react-navigation/stack';
import { NavigationContainer } from '@react-navigation/native';

import Todo from "./src/components/Todo"
import Desc from "./src/components/Desc"
import Login from "./src/components/Login"

const Stack = createStackNavigator();

function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Login" component={Login} />
        <Stack.Screen name="Todo" component={Todo} />
        <Stack.Screen name="Desc" component={Desc} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

export default App;