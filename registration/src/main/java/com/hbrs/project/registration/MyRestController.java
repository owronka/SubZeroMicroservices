package com.hbrs.project.registration;


import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hbrs.project.registration.DB.JDBCConnection;

@RestController
public class MyRestController{



@RequestMapping("/registration/web")
public Registration getRegistration(@RequestBody Registration stats ) throws SQLException {
	
	JDBCConnection jdbc = JDBCConnection.getInstance();
	PreparedStatement preparedStatement = jdbc.getPreparedStatement("INSERT INTO HBRS.PERSON(anrede,vorname,nachname,email)"
			+ "VALUES(?,?,?,?)"); 
	preparedStatement.setString(1,stats.getAnrede());
	preparedStatement.setString(2,stats.getVorname());
	preparedStatement.setString(3,stats.getName());
	preparedStatement.setString(4,stats.getEmail());
	preparedStatement.execute();
	
	PreparedStatement preparedStatement1 = jdbc.getPreparedStatement("INSERT INTO HBRS.ADDRESS(strasse,hausnummer,plz,stadt)"
			+ "VALUES(?,?,?,?)"); 
	preparedStatement1.setString(1,stats.getStrasse());
	preparedStatement1.setString(2,stats.getHnummer());
	preparedStatement1.setString(3,stats.getPlz());
	preparedStatement1.setString(4,stats.getStadt());
	preparedStatement1.execute();

	PreparedStatement preparedStatement2 = jdbc.getPreparedStatement("INSERT INTO HBRS.ACCOUNT(benutzer,password)"
			+ "VALUES(?,?)"); 
	preparedStatement2.setString(1,stats.getBenutzer());
	preparedStatement2.setString(2,stats.getPw());
	preparedStatement2.execute();
	
	return new Registration(stats.getAnrede(), stats.getVorname(), stats.getName()
			,stats.getEmail() ,stats.getBenutzer() , stats.getPw() ,stats.getPwhl() , stats.getPlz() , stats.getStadt()
			, stats.getStrasse() , stats.getHnummer());
} 
}