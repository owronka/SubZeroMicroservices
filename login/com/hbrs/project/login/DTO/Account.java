package com.hbrs.project.login.DTO;


public class Account {

    
    private Integer id;     
    private Integer personId;
    private String name;
    private String passwordHash;
    private String salt;  
    private Login login;
     
    public Account() {  
    }

   public Account(Integer id, Integer personId, String name, String passwordHash, String salt,  Login login){

	this.id = id;
        this.name = name;
        this.passwordHash = passwordHash;
        this.salt = salt;
        this.login = login;

    }
     
    public Login getLogin() {
        return login;
    }
     
    public void setLogin(Login login) {
        this.login = login;
    }
     
    public Integer getId() {
        return id;
    }
     
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getPersonId() {
        return personId;
    }
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(String password) {
        //this.passwordHash = ;
    }
    public String getSalt() {
        return salt;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    }
     
    
}