package org.h_brs.coolemicroservices.facade.dto;


public class PersonTO {
	
	private String salutation;
	private String firstname;
	private String lastname;
	private String email;
	private String username;
	private String password;
	private String country;
	private String postcode;
	private String place;
	private String street;
	private String housenumber;
	
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHousenumber() {
		return housenumber;
	}
	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}
	@Override
	public String toString() {
		return "PersonTO\nsalutation = " + salutation + "\nfirstname = " + firstname + "\nlastname = " + lastname + "\nemail = "
				+ email + "\nusername = " + username + "\npassword = " + password + "\ncountry = " + country + "\npostcode = "
				+ postcode + "\nplace = " + place + "\nstreet = " + street + "\nhousenumber = " + housenumber;
	}
}