import React from "react";
import { createStackNavigator } from '@react-navigation/stack';
import { NavigationContainer } from '@react-navigation/native';

import Login from './src/components/Login';
import ToDo from './src/components/ToDo';

const Stack = createStackNavigator();

function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Login" component={Login} />
        <Stack.Screen name="ToDo" component={ToDo} />
        
      </Stack.Navigator>
    </NavigationContainer>
  );
}

export default App;