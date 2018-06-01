package com.axxessio.axx2cld.registration.facade.to;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonTO extends GenericTO {
	private long personId;
	
	private String salutation;
	private String firstName;
    private String lastName;
    private String email;
    private AccountTO acto = null;
    private AddressTO[] adtos = null; 

    @JsonCreator
    public PersonTO(@JsonProperty("personId") long personId, @JsonProperty("salutation") String salutation, @JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("email") String email) {
		super();
		this.personId = personId;
		this.salutation = salutation;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
    public PersonTO(String salutation, String firstName, String lastName, String email) {
		super();
		this.salutation = salutation;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

    public String getSalutation() {
		return salutation;
	}
	
    public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	
    public String getFirstName() {
		return firstName;
	}
	
    public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
    public String getLastName() {
		return lastName;
	}
	
    public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
    public String getEmail() {
		return email;
	}
	
    public void setEmail(String email) {
		this.email = email;
	}

	public AccountTO getAccount() {
		return acto;
	}

	public void setAccount(AccountTO acto) {
		this.acto = acto;
	}

	public AddressTO[] getAddress() {
		return adtos;
	}

	public void setAddress(AddressTO[] adtos) {
		this.adtos = adtos;
	}
}
  