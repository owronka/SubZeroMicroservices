package com.axxessio.axx2cld.login;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Person{
	 @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	private final long id;
	private String name;
	private String password;
	private String email;
		
	public Person() {
		this.id = 0;
	}
	
	
	public Person(long id, String username, String password) {
		this.id = id;
		this.name = name;
	    this.password = password;	       
	    }
	    
	public long getId() {
	    return id;
	    }

	public String getName() {
	    return name;
	    }
	
	public void setName(String username) {
	    this.name = username;
	    }
	
	public String getPassword() {
	    return password;
	    }
	
	public void setPassword(String password) {
	    this.password = password;
	    }		
	
	public String getEmail() {
	    return email;
	    }
	
	public void setEmail(String email) {
	    this.email = email;
	    }		
}
