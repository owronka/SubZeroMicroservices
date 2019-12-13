package com.hbrs.project.registration.DB;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;

import java.util.logging.Logger;

public class JDBCConnection{

//private static JDBCConnection connection = null;
//private final String url = "jdbc:derby://localhost:1527/HBRS;create=true";
//private Connection conn;
	
    	// must be connected with vpn to access db
	private static JDBCConnection connection = null;
	private static final String url = "jdbc:derby://localhost:1527/HBRS;create=true";
	private static Connection conn  = null;
	
	
    
 /* String url = "jdbc:derby://localhost:1527/HBRS;create=true";
  Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
 try (Connection conn = DriverManager.getConnection(url)){
	
 String SQL = "SELECT * FROM ACCOUNT";
 Statement stmt = conn.createStatement();
 ResultSet rs = stmt.executeQuery(SQL);
 
 while(rs.next()){
  System.out.println(rs.getString("ID") + " " + (rs.getString("name")));
  }
  
}
catch (SQLException e){
e.printStackTrace();
}
 
 
}*/
public static JDBCConnection getInstance() {
	if (connection == null) {
		connection = new JDBCConnection();
	}
	return connection;
}

private JDBCConnection()  {
	this.initConnection();
}

public void initConnection()  {
	try {
		DriverManager.registerDriver((new org.apache.derby.jdbc.ClientDriver()));
	} catch (SQLException e) {
		Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, e);
	}
	this.openConnection();
}

public void openConnection()  {
	
	try {
	
	Properties props = new Properties();
	JDBCConnection.conn = DriverManager.getConnection(this.url, props);
	
	} catch (SQLException e) {
		Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, e);

  }
}		

public Statement getStatement() {
	try {
		if(JDBCConnection.conn.isClosed()) {
			this.openConnection();
		}
		return (Statement) JDBCConnection.conn.createStatement();
	} catch (SQLException e) {
	Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, e);
	return null;
  }
}

public void closeConnection() {
	try {
		JDBCConnection.conn.close();
	} catch (SQLException e) {
		Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, e);
	}
}


 public PreparedStatement getPreparedStatement(String sql)  {
    
    try {
        if( JDBCConnection.conn.isClosed() ) {                
            this.openConnection();
        }
        return JDBCConnection.conn.prepareStatement(sql);  
    } 
    catch (SQLException ex) {
        Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex); //loggt die Exceptions
        return null;
    } 
 
 }
 public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {


	 try {
			 Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			 conn = DriverManager.getConnection(url);
	 } 
			 catch (SQLException ex){
				 ex.printStackTrace();
				 }
			
		 String SQL = "SELECT * FROM HBRS.PERSON";
		 Statement stmt = conn.createStatement();
		 ResultSet rs = stmt.executeQuery(SQL);
		 
		 while(rs.next()){
		  System.out.println(rs.getString("nachname") + " " + (rs.getString("vorname")));
		  }
		  
		
}
}




	
