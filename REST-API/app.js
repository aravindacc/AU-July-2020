//jshint esversion:6
const express = require("express");
const bodyParser = require("body-parser");
const mongoose= require("mongoose");

const _ = require("lodash");


const app = express();

app.use(bodyParser.urlencoded({extended: true}));

mongoose.connect("mongodb+srv://admin-aman:22192862Aa@@cluster0-5odxb.mongodb.net/accolite",{useNewUrlParser:true, useUnifiedTopology: true})
mongoose.set("useCreateIndex",true)

const todoschema= {
 
  title:String,
  story:String
}
const Other= mongoose.model("Other",todoschema)


app.get("/todos", function(req, res){
  Other.find({}, function(err, todos){
    res.json((todos))
  })

});
app.post("/compose", bodyParser.json(),function(req, res){
    const item = new Other({
        
        title:req.body.title,
        story:req.body.story
    })
  console.log(req.body)
    item.save()
    
  
  
  });

app.delete("/remove",bodyParser.json(),(req,res)=>{

 Other.findByIdAndRemove(req.body.id,(err)=>{
   if(!err)
   console.log("done");

 })
console.log(req.body.id)


})




app.listen(9000, function() {
  console.log("Server started on port 3000");
});
