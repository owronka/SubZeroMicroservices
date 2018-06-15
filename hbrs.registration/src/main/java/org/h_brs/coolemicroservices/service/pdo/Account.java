package org.h_brs.coolemicroservices.service.pdo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account {
	
	public Account(int personID) {
		this.personID= personID;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
	@SequenceGenerator(name = "ACCOUNT_ID", sequenceName = "ACCOUNT_ID", allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "BENUTZER")
	private String benutzer;
	@Column(name = "PASSWORT")
	private String passwort;
	@Column(name = "PERSONID")
	private Integer personID ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBenutzer() {
		return benutzer;
	}
	public void setBenutzer(String benutzer) {
		this.benutzer = benutzer;
	}
	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	public Integer getPersonID() {
		return personID;
	}
	public void setPersonID(Integer personID) {
		this.personID = personID;
	}
	
}
