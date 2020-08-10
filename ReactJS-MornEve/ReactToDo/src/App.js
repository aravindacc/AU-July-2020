import React, { useState } from 'react';
import './App.css';
import ToDoList from './components/ToDoList';
import 'bootstrap/dist/css/bootstrap.min.css';

function App(props) {
  const [inputList, setInput] = useState("");
  const [items, setItems] = useState([]);

  const itemEvent = (event) => {
    setInput(event.target.value);
  };

  const saveThing = (item) => {
    // console.log(item);
    setItems((prevItems) => {
      const items = {...prevItems}
      items[item.id] = item
      // setItems({ items })
    })
  }

  const listOfItems = () => {
    setItems((prevItems) => {
      return [...prevItems, inputList];
    })
    setInput("");
  };

  const deleteItems = (id) => {
    setItems((prevItems) => {
      return prevItems.filter((arrElem, index) => {
        return index !== id;
      })
    })
  }

  return (
    <div className="App">
      <div className="center_div">
        {/* <br /> */}
        <h1> ToDo List </h1>
        {/* <br /> */}
        <input id="title" type="text" placeholder="Add a items" value = {inputList} onChange={itemEvent} />
        <button onClick={listOfItems}> 
          <i className="fas fa-bars" />
        </button>

        <ol>
          {items.map((itemValue, index) => {
            return <ToDoList key={index} 
            id={index} text={itemValue}
            saveThing={saveThing}
            onDelete={deleteItems} />;
          })}
        </ol>
      </div>
    </div>
  );
}


export default App;
