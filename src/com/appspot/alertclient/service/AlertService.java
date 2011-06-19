package com.appspot.alertclient.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("/service")
public class AlertService {
	
	@GET
	@Path("example")
	@Produces("text/plain")
	public String getName(){
		return "Ya this is alert-client with GET Request";
	}
}
