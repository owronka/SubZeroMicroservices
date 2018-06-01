package com.axxessio.axx2cld.registration.service.pdo;

import java.io.Serializable;

import javax.persistence.*;

import com.axxessio.axx2cld.registration.facade.to.AccountTO;

/**
 * The persistent class for the DPUSER database table.
 * 
 */
@Entity
@Table(name = "A2C_ACCOUNT")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private String password;
	private String salt;
	
	private Person person;
	
	public Account() {
	}

	public Account(AccountTO accountTO, String newPassword, String newSalt) {
		this.setName(accountTO.getAccountName());
		this.password = newPassword;
		this.salt = newSalt;
	}

	@Transient
	public AccountTO getAccount() {
		return new AccountTO (this.id, this.name, this.password, this.salt); 
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
	@SequenceGenerator(name = "account_seq", sequenceName = "A2C_ACCOUNT_ID", allocationSize = 1)
	@Column(name = "AC_ID")

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "AC_NAME", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "AC_PASSWORD", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "AC_SALT", nullable = false)
	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AC_P_ID")
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}