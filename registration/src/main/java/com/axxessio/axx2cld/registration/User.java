package com.axxessio.axx2cld.registration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class User {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)

	private String vorname;
	private String name;
	private String email;
	private String password;
	private int id;
	
	public User(String vorname, String name, String email, String password, int id) {
		this.setVorname(vorname);
		this.setName(name);
		this.setEmail(email);
	    this.setPassword(password);	       
	    this.setId(id);
	
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	    
		
}
