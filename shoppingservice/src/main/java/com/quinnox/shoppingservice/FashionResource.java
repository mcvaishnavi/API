package com.quinnox.shoppingservice;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// fashionServiceAPI/fashionAPI


@Path("/fashionServiceAPI")
//@CrossOrigin(origins="http://127.0.0.1:5500")
public class FashionResource {
	
	
	fashionMockup mockup = new fashionMockup();
	
	@GET
	@Path("/getFashion")
	@Produces(MediaType.APPLICATION_JSON)
	public List<fashion> getfashion() throws SQLException{
		for(fashion fashion: mockup.getfashion())
		System.out.println(fashion.toString());
		return mockup.getfashion();
	}
	
	@POST
	@Path("/fashionAPI")
	@Produces(MediaType.APPLICATION_JSON)
	public fashion createNewfashion(fashion f) throws Exception {
		
		mockup.createfashion(f);
		return f;
	}
	
	@GET
	@Path("fashionAPI/{item_name}")
	@Produces(MediaType.APPLICATION_JSON)
	public fashion getfashion(@PathParam ("item_name")String item_name) {
		return mockup.getfashion(item_name);
	}
	
	@PUT
	@Path("fashionAPI")
	@Consumes(MediaType.APPLICATION_JSON)
	public fashion updatefashion(fashion f) throws Exception {
		
		mockup.updatefashion(f);
		return f;
	}
	
	@DELETE
	@Path("fashionAPI/{item_name}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void dropFashion(@PathParam ("item_name")String item_name)throws Exception {
		
		mockup.dropFashion(item_name);
		
	}
	
	
}