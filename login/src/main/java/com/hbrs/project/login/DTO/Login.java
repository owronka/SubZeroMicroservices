package com.hbrs.project.login.DTO;

public class Login {
     
     
        private Integer id;
       
	private String passwordHash;
   
        private Account account;
         
  
        public Login() {
              
         }
        
        public Login(Integer id, String passwordHash, Account account ) {
        	this.account = account;
        	this.id = id;
        	this.passwordHash = passwordHash;
        }
 
 
        public String getAccountName() {
            return this.account.getName();
        }
        public String getPasswordHash() {
            return this.account.getPasswordHash();
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