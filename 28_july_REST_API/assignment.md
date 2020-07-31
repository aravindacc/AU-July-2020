## Mukesh Suthar 
### mukesh.suthar@accoliteindia.com


## Rest-Api todo application 


- **Geting list of todo item**
 - http://localhost:9090/Rest_api_todo/rest/getlist
 - ```[{"40":"wakeup"},{"41":"eat"},{"42":"walk"}]```


- **Adding item to todo App**
 - localhost:9090/Rest_api_todo/rest/Todo/add?todo=item_to_add
 - ```{"result":"inserted successfully"}```
 - Note : todo is query parameter

- **Deleting item from todo App**
 - http://localhost:9090/Rest_api_todo/rest/Todo/delete/40
 - ```{"result":"deleted successfully"}```
 - Note : id is path parameter
