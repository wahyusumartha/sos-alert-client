package com.appspot.alertclient;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import com.appspot.alertclient.model.Report;
import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class AlertRestClient extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
//		Client client = Client.create();
//		
//		WebResource webResource = client.resource("http://sos-alert.appspot.com/rest/activitieslist");
//		String response = webResource.path("reports").accept(MediaType.APPLICATION_JSON).get(String.class);
//		
//		resp.setContentType("text/plain");
//		resp.getWriter().write(response);
		String name = req.getParameter("name");
		String description = req.getParameter("message");
		String latitude = req.getParameter("latitude");
		String longitude = req.getParameter("longitude");
		String priority = req.getParameter("priority");
		
		resp.setContentType("text/plain");
		resp.getWriter().write(name + " - " + description + " - " + latitude + " - " + longitude + " - " + priority);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		final String BASE_URI = "http://sos-alert.appspot.com/rest/activitieslist";
		
		ClientConfig config  = new DefaultClientConfig();
		Client client = Client.create(config);
		
		WebResource service = client.resource(BASE_URI);
		
		
		String name = req.getParameter("name");
		String description = req.getParameter("message");
		String latitude = req.getParameter("latitude");
		String longitude = req.getParameter("longitude");
		String priority = req.getParameter("priority");
		
		if(name.equals("") || description.equals("") || latitude.equals("")
				|| longitude.equals("") || priority.equals("")){
			JSONObject message = new JSONObject();
			try {
				message.put("status", "ok");
				message.put("msg", "Please Fill Your Form Completely");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.getWriter().write(message.toString());
		}else{
			Report report = new Report();
			report.setName(name);
			report.setDescription(description);
			report.setLatitude(latitude);
			report.setLongitude(longitude);
			report.setPriority(priority);

			ClientResponse response = service.path("postreport")
					.type(MediaType.APPLICATION_JSON)
					.post(ClientResponse.class, report);

			resp.sendRedirect("/");
		}
	}

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		
//		String name = req.getParameter("name");
//		String description = req.getParameter("message");
//		String latitude = req.getParameter("latitude");
//		String longitude = req.getParameter("longitude");
//		String priority = req.getParameter("priority");
//		
//		if(name ==)
//	}
	
	
	
	
}
