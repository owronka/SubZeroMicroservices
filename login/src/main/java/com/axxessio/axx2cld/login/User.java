package com.axxessio.axx2cld.login;

public class User {

	private final long id;
	private String name;
	private String password;
	private String email;
		
	public User() {
		this.id = 0;
	}
	
	
	public User(long id, String username, String password) {
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
