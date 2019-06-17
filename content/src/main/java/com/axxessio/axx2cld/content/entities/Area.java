package com.axxessio.axx2cld.content.entities;

import org.springframework.data.annotation.Id;

public class Area{
	
	@Id private String id;
	private String name;
	
	public Area() {
	}

    public String getId() {
    	return this.id;
    }
    
    public void setId(String id) {
    	this.id=id;
    }
    
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
