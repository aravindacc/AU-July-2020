package com.test;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import com.test.service.DBService;

@Path("/Todo")
public class manipulation {
	  DBService db = new DBService();
	  @GET
	  @Path("/add")
	  public String add(@QueryParam("todo") String item ) {
		  JSONObject result = new JSONObject();
		 if(!item.isEmpty() && db.insert(item))
			 result.put("result" , "inserted successfully");
		 else
			 result.put("result" , "insertion failed");
		 return result.toJSONString();
	  }
	  
	  @GET
	  @Path("/delete/{id}")
	  public String delete(@PathParam("id") int index ) {
		  JSONObject result = new JSONObject();
			 if(db.delete(index))
				 result.put("result" , "deleted successfully");
			 else
				 result.put("result" , "deletion failed");
			 return result.toJSONString();
	  }
}
