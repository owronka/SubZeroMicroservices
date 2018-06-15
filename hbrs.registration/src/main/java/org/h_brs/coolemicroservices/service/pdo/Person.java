package org.h_brs.coolemicroservices.service.pdo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.axxessio.axx2cld.registration.service.pdo.Account;
import com.axxessio.axx2cld.registration.service.pdo.Address;

@Entity
@Table(name="A2C_PERSON")
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9221198451940445764L;

	private int id;
	private String anrede;
	private String vorname;
	private String nachname;
	private List<Account> acs;
    private List<Address> ads;
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="person_seq")
    @SequenceGenerator(name="person_seq",sequenceName="PERSON_ID", allocationSize=1)
    @Column(name="P_ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="ANREDE")
	public String getAnrede() {
		return anrede;
	}
	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}
	@Column(name="VORNAME")
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	@Column(name="NACHNAME")
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	@OneToMany(mappedBy="person")
	public List<Account> getAcs() {
		return acs;
	}
	public void setAcs(List<Account> acs) {
		this.acs = acs;
	}
	@OneToMany(mappedBy="person")
	public List<Address> getAds() {
		return ads;
	}
	public void setAds(List<Address> ads) {
		this.ads = ads;
	}
}
