package com.axxessio.axx2cld.registration.facade.to;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressTO extends GenericTO {

	private long addressId;

	private String country;
	private String city;
	private String zip;
	private String houseNumber;
	private String street;
	private String type;
	
	@JsonCreator
	public AddressTO(@JsonProperty("addressId") long newAddressId, @JsonProperty("country") String newCountry, @JsonProperty("city") String newCity, @JsonProperty("zip") String newZip, @JsonProperty("houseNumber") String newHouseNumber, @JsonProperty("street") String newStreet, @JsonProperty("type") String newType) {
		super();
		this.addressId = newAddressId;
		this.country = newCountry;
		this.city = newCity;
		this.zip = newZip;
		this.houseNumber = newHouseNumber;
		this.street = newStreet;
		this.type = newType;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long newAddressId) {
		this.addressId = newAddressId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String newCountry) {
		this.country = newCountry;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String newCity) {
		this.city = newCity;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String newZip) {
		this.zip = newZip;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String newHouseNumber) {
		this.houseNumber = newHouseNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String newStreet) {
		this.street = newStreet;
	}

	public String getType() {
		return type;
	}

	public void setType(String newType) {
		this.type = newType;
	}
}
  