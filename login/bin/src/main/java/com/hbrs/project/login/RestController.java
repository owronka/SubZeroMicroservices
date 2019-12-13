package com.hbrs.project.login;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hbrs.project.registration.DB.JDBCConnection;

import com.hbrs.project.login.DTO.Login;

@RestController
public class RestController{



@RequestMapping("/login/web")
public Login getlogin(@RequestBody String name) throws SQLException{

    JDBCConnection jdbc = JDBCConnection.getInstance();
	
    PreparedStatement preparedStatement = jdbc.getPreparedStatement("INSERT INTO HBRS.ACCOUNT(nickname,password)"
			+ "VALUES(?,?)"); 
	preparedStatement.setString(1,stats.getNickname());
	preparedStatement.setString(2,stats.getPassword());
	
	preparedStatement.execute();
	return new Login(stats.getNickname(), stats.getPassword());
}

} 