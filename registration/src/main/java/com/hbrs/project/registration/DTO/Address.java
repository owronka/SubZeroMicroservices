package com.hbrs.project.registration.DTO;

public class Address{

private long address_id;
private String stadt;
private String land;
private String strasse;
private long hausnummer;
private long plz;

public Address( long newAddress_ID, String newStadt, String newLand, String newStrasse, long newHausnummer, long newPLZ){
super();
this.address_id = newAddress_ID;
this.stadt = newStadt;
this.land = newLand;
this.strasse = newStrasse;
this.hausnummer = newHausnummer;
this.plz = newPLZ;
}

public long getAddress_ID(){
return address_id;
}

public long setAddress_ID( long newAddress_ID){
return this.address_id = newAddress_ID;
}

public String getStadt(){
return stadt;
}

public String setStadt( String newStadt){
return this.stadt = newStadt;
}

public String getLand (){
return land;
}

public String setLand( String newLand){
return this.land = newLand;
}

public String getStrasse (){
return strasse;
}

public String setStrasse( String newStrasse){
return this.strasse = newStrasse;
}

public long getHausnummer (){
return hausnummer;
}
public long setHausnummer( long newHausnummer){
return this.hausnummer = newHausnummer;
}

public long getPLZ (){
return plz;
}
public long setPLZ( long newPLZ){
return this.plz = newPLZ;
}

}

