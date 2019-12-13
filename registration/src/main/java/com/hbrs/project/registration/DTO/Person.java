package com.hbrs.project.registration.DTO;

public class Person{

private long p_id;
private String vorname;
private String nachname;
private String anrede; 
private String firma;
private String email;
private long telefon;

public Person( long newP_ID, String newAnrede, String newVorname, String newNachname, String newFirma, String newEmail, long newTelefon){
super();
this.p_id = newP_ID;
this.vorname = newVorname;
this.nachname = newNachname;
this.anrede = newAnrede;
this.firma = newFirma;
this.email = newEmail;
this.telefon = newTelefon;
}

public long getP_ID(){
return p_id;
}

public long setP_ID ( long newP_ID){
return this.p_id = newP_ID;
}

public String getVorname(){
return vorname;
}

public String setVorname (String newVorname){
return this.vorname = newVorname;
}

public String getNachname(){
return nachname;
}

public String setNachname(String newNachname){
return this.nachname = newNachname;
}

public String getAnrede(){
return anrede;
}

public String setAnrede ( String newAnrede){
return this.anrede = newAnrede;
}

public String getFirma(){
return firma;
}

public String setFirma ( String newFirma){
return this.firma = newFirma;
}

public String getEmail(){
return email;
}

public String setEmail(String newEmail){
return this.email= newEmail;
}

public long getTelefon(){
return telefon;
}

public long setTelefon(long newTelefon){
return this.telefon = newTelefon;
}
}

