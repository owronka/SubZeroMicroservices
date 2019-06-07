package com.axxessio.axx2cld.registration.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    private Long id;
    private String anrede;
    private String vorname;
    private String nachname;
    private String username;
    private String email;
    private String password;
    private String passwordConfirm;
  

@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

public void setId(Long id) {
        this.id = id;
    }

public String getUsername() {
        return username;
    }

public void setUsername(String username) {
        this.username = username;
    }

public String getAnrede () {
	return anrede;
}

public void setAnrede (String anrede) {
    this.anrede = anrede;
}

public String getVorname () {
	return vorname;
}

public void setVorname (String vorname) {
    this.vorname = vorname;
}
public String getNachname () {
	return nachname;
}

public void setNachname (String nachname) {
    this.nachname = nachname;
}

public String getEmail () {
	return email;
}

public void setEmail (String email) {
    this.email = email;
}

public String getPassword() {
        return password;
    }

public void setPassword(String password) {
        this.password = password;
    }

@Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}


