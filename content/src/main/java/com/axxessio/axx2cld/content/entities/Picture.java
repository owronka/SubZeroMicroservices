package com.axxessio.axx2cld.content.entities;

import org.springframework.data.annotation.Id;

public class Picture{
	
	@Id private String id;
	
	private String subareaId;
	private String name;
	private String url;
	private Double size;
	private String date;
	
	public Picture() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubareaId() {
		return subareaId;
	}
	public void setSubareaId(String subareaId) {
		this.subareaId = subareaId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Double getSize() {
		return size;
	}
	public void setSize(Double size) {
		this.size = size;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
	
}
