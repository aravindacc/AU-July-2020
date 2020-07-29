import React, { useState, useEffect } from "react";
import Header from "./Header";
import Footer from "./Footer";
import Note from "./Note";
import CreateArea from "./CreateArea";

function App() {
  const [notes, setNotes] = useState([]);

  function addNote(newNote) {
    setNotes(prevNotes => {
      return [...prevNotes, newNote];
    });
  }
  useEffect(() => {
    //console.log(notes);
    // sessionStorage.clear();
    // sessionStorage.setItem("todos", JSON.stringify(notes));
    var x = JSON.parse(sessionStorage.getItem("todos"));
    x.forEach(item => console.log(item));
  }, [notes]);

  function deleteNote(id) {
    setNotes(prevNotes => {
      return prevNotes.filter((noteItem, index) => {
        return index !== id;
      });
    });
    // sessionStorage.clear();
    // sessionStorage.setItem("todos", JSON.stringify(notes));
  }

  return (
    <div>
      <Header />
      <CreateArea onAdd={addNote} />
      {sessionStorage.setItem("todos", JSON.stringify(notes))}
      {JSON.parse(sessionStorage.getItem("todos")).map((noteItem, index) => {
        return (
          <Note
            key={index}
            id={index}
            title={noteItem.title}
            content={noteItem.content}
            onDelete={deleteNote}
          />
        );
      })}
      <Footer />
    </div>
  );
}

export default App;
