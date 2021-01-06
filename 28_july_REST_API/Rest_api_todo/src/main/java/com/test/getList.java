package com.test;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.test.service.DBService;
 

@Path("/getlist")
public class getList {

  DBService db = new DBService();
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getTestService() {
    return db.getList().toJSONString();
  }
  
}