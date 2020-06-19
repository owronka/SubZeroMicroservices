package com.axxessio.axx2cld.registration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String Anrede;
	private String vorname;
	private String nachname;

	
	/*public User(String vorname, String name, String email, String password, int id) {
		this.setVorname(vorname);
		this.setName(name);
		this.setEmail(email);
	    this.setPassword(password);	       
	    this.setId(id);
	
	}*/
	
	public String getAnrede() {
		return Anrede;
	}

	public void setAnrede(String anrede) {
		Anrede = anrede;
	}
	  
	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
		
}
