package com.hbrs.project.registration;

public class Registration{
	private String anrede;
	private String vorname;
	private String name;
	private String email;
	private String benutzer;
	private long pw;
	private long pwhl;
	private String plz;
	private String stadt;
	private String strasse;
	private String hnummer;
	
	public Registration(String anrede, String vorname, String name, String email,
		String benutzer, long pw, long pwhl, String plz, String stadt,  String strasse, String hnummer){
		this.anrede = anrede;
		this.vorname = vorname;
		this.name = name;
		this.email = email;
		this.benutzer = benutzer;
		this.pw = pw;
		this.pwhl = pwhl;
		this.plz = plz;
		this.stadt = stadt;
		this.strasse = strasse;
		this.hnummer = hnummer;
	}
	public String getAnrede() {
		return anrede;
	}
	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBenutzer() {
		return benutzer;
	}
	public void setBenutzer(String benutzer) {
		this.benutzer = benutzer;
	}
	public long getPw() {
		return pw;
	}
	public void setPw(long pw) {
		this.pw = pw;
	}
	public long getPwhl() {
		return pwhl;
	}
	public void setPwhl(long pwhl) {
		this.pwhl = pwhl;
	}
	public String getPlz() {
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
	public String getStadt() {
		return stadt;
	}
	public void setStadt(String stadt) {
		this.stadt = stadt;
	}
	public String getStrasse() {
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	public String getHnummer() {
		return hnummer;
	}
	public void setHnummer(String hnummer) {
		this.hnummer = hnummer;
	}

enum anrede
{
	Herr, Frau, Firma;
}
}