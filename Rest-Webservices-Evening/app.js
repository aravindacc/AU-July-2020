const express = require('express')
const app = express()
var bodyParser = require('body-parser')

const port = 3000

app.use(bodyParser.urlencoded({extended:false})) 
app.use(bodyParser.json()) 

var todo = [];
app.get('/todos', (req, res) => res.json(todo))
app.post('/todos', (req, res) => {
    todo.push(req.body.todo);
    return res.json("todo added");
})

app.put('/updateTodo', (req, res) => { 
    console.log(req);
    var temp = req.body.oldtodo;
    var index = todo.indexOf(temp);
    if(index == -1){
        res.send("No todo found, that you want to change or update")
    }
    else{
        todo.splice(index,1,req.body.newtodo);
        
        res.send("todo updated"); 
    }
    
  }) 

  app.delete('/deleteTodo',(req,res) =>{
    var temp = req.body.todo;
    var index = todo.indexOf(temp);
    if(index == -1){
        res.send("todo not found")
    }
    else{
        todo.splice(index,1);
        
        res.send("todo deleted"); 
    }
  })




app.listen(port, () => console.log(`Example app listening at http://localhost:${port}`))