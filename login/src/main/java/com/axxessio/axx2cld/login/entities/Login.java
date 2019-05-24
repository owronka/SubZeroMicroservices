package com.axxessio.axx2cld.login.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Login {
	
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Integer id;
		
      	private String passwordHash;
	    
	    @OneToOne(mappedBy = "login")
	    @JsonIgnore
	    private Account account;
	    
 
		public Login() {
			 
		 }


		public String getAccountName() {
			return this.account.getName();
		}
		public String getPasswordHash() {
			return this.account.getPasswortdHash();
		}
		
		public String getSalt() {
			return this.account.getSalt();
		}

		public Integer getId() {
			return id;
		}




		public void setId(Integer id) {
			this.id = id;
		}




		public Account getAccount() {
			return account;
		}




		public void setAccount(Account account) {
			this.account = account;
		}
		
		

}
