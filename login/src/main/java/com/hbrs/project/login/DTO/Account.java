package src.main.java.com.hbrs.project.login.DTO;


public class Account {

    
    private int id;     
    private int personId;
    private String name;
    private String passwordHash;
    private String salt;  
    private Login login;
     
    public Account() {  
    }
     
    public Login getLogin() {
        return login;
    }
     
    public void setLogin(Login login) {
        this.login = login;
    }
     
    public int getId() {
        return id;
    }
     
    public void setId(int id) {
        this.id = id;
    }
    public int getPersonId() {
        return personId;
    }
    public void setPersonId(int personId) {
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
        this.passwordHash = passwordHash;
    }
    public String getSalt() {
        return salt;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    }
     
     
 
}