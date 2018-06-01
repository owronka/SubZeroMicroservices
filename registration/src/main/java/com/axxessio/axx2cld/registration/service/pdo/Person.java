package com.axxessio.axx2cld.registration.service.pdo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.axxessio.axx2cld.registration.facade.to.PersonTO;


/**
 * The persistent class for the DPUSER database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Person.findByVersion", query = "SELECT p FROM Person p WHERE p.version>?1"),
	@NamedQuery(name = "Person.findByVersionAndId", query = "SELECT p FROM Person p WHERE p.version>?1 and p.id>?2")})
@Table(name="A2C_PERSON")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
    private String salutation;
    private String firstName;
    private String lastName;
    private String email;
    private List<Account> acs;
    private List<Address> ads;
    private long version;

    public Person() {
    }

    public Person(PersonTO pto, long newVersion) {
    	this.id = pto.getPersonId();
    	this.email = pto.getEmail();
    	this.firstName = pto.getFirstName();
    	this.lastName = pto.getLastName();
      	this.version = newVersion;
    }
    
	@Transient
    public PersonTO getPerson () {
    	return new PersonTO(this.id, this.salutation, this.firstName, this.lastName, this.email);
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="person_seq")
    @SequenceGenerator(name="person_seq",sequenceName="A2C_PERSON_ID", allocationSize=1)
    @Column(name="P_ID")
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

   @Column(name="P_SALUTATION")
	public String getSalutation() {
		return this.salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

    @Column(name="P_FIRST_NAME", nullable=false)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

    @Column(name="P_LAST_NAME", nullable=false)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

   @Column(name="P_EMAIL")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@OneToMany(mappedBy="person")
	public List<Address> getAddress() {
		return this.ads;
	}

	public void setAddress(List<Address> ads) {
		this.ads = ads;
	}

    @OneToMany(mappedBy="person")
	public List<Account> getAccount() {
		return this.acs;
	}

	public void setAccount(List<Account> acs) {
		this.acs = acs;
	}

	public void setAccount(Account ac) {
		this.acs.add(ac);
	}

    @Column(name="P_VERSION", nullable=false)
	public long getVersion() {
		return this.version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}