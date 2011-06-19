package com.appspot.alertclient.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Report {
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private String latitude;
	
	private String longitude;
	
	private String priority;
	
	public Report(){
		
	}
	
	public Report(Long id, String name, String description, String latitude, String longitude,
			String priority){
		this.id = id;
		this.name = name;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
		this.priority = priority;
	}
	
	public Long getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String getLatitude(){
		return latitude;
	}
	
	public String getLongitude(){
		return longitude;
	}
	
	public String getPriority(){
		return priority;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public void setLatitude(String latitude){
		this.latitude = latitude;
	}
	
	public void setLongitude(String longitude){
		this.longitude = longitude;
	}
	
	public void setPriority(String priority){
		this.priority = priority;
	}
}
