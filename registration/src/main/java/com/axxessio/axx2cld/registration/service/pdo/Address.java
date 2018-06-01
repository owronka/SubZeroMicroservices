package com.axxessio.axx2cld.registration.service.pdo;

import java.io.Serializable;

import javax.persistence.*;

import com.axxessio.axx2cld.registration.facade.to.AddressTO;

/**
 * The persistent class for the DPUSER database table.
 * 
 */
@Entity
@Table(name = "A2C_ADDRESS")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;

	private String country;
	private String city;
	private String zip;
	private String houseNumber;
	private String street;
	private String type;
	
	private Person person;
	
	public Address() {
	}

	public Address(AddressTO addressTO) {
		this.id = addressTO.getAddressId();
		this.country = addressTO.getCountry();
		this.city = addressTO.getCity();
		this.zip = addressTO.getZip();
		this.houseNumber = addressTO.getHouseNumber();
		this.street = addressTO.getStreet();
		this.type = addressTO.getType();
	}

	@Transient
	public AddressTO getAddress() {
		return new AddressTO(this.id, this.country, this.city, this.zip, this.houseNumber, this.street, this.type); 
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
	@SequenceGenerator(name = "address_seq", sequenceName = "A2C_ADDRESS_ID", allocationSize = 1)
	@Column(name = "AD_ID")
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "AD_COUNTRY", nullable = false)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "AD_CITY", nullable = false)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "AD_ZIP", nullable = false)
	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name = "AD_HOUSENUMBER", nullable = true)
	public String getHouseNumber() {
		return this.houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}


	@Column(name = "AD_STREET", nullable = false)
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	@Column(name = "AD_TYPE", nullable = false)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AD_P_ID")
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}