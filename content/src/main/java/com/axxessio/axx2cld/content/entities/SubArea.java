package com.axxessio.axx2cld.content.entities;

import org.springframework.data.annotation.Id;

public class SubArea{
	
	@Id private String id;
	private String areaId;
	private String name;
	
	public SubArea() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
