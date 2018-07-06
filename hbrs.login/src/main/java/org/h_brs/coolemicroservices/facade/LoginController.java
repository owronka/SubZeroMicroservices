package org.h_brs.coolemicroservices.facade;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.h_brs.coolemicroservices.facade.dto.AccountTO;
import org.h_brs.coolemicroservices.services.LoginService;
import org.h_brs.coolemicroservices.services.pdo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping( method=RequestMethod.POST, value="/login/srv" )
	public String login( @RequestBody String jsonInString ) {
		
		/*
		 * JASON EINGABE KONVERTIEREN ZUM JAVA OBJEKT
		 * ACCOUNTTO.java
		 */
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			// Convert JSON string from file to Object
			AccountTO input_accountTO = mapper.readValue( jsonInString, AccountTO.class );
			
			System.out.println( "Try to get Account for Email" );
			Account db_account = loginService.getAccount( input_accountTO.getEmail() );
			
			if( db_account == null ) { //Abbruch falls Account nicht vorhanden!
				System.out.println( "No Account for this Email" );
				return buildJason( false, "Email nicht vorhanden!" );
			}
			System.out.println( "Account succsesfully delivered" );
			
			System.out.println( "Try map Password to Byte[]" );
			byte[] input_password = input_accountTO.getPasswort().getBytes( StandardCharsets.UTF_8 );
			System.out.println( "Password was mapped to Byte[]" );
			
			System.out.println( "Try get Salt for Email" );
			byte[] db_salt = db_account.getSalt().getBytes( StandardCharsets.UTF_8 );
			System.out.println( "Salt was mapped to byte[]" );
			
			System.out.println( "Try to create encodedHash for Account Password" );
			byte[] input_encodedHash = encodedHash( catenatePwdAndSalt( input_password , db_salt));
			System.out.println( "encodedHash was Account Password" );
			
			System.out.println( "Try map db_Password to byte[]" );
			byte[] db_password = db_account.getPasswort().getBytes( StandardCharsets.UTF_8 );
			System.out.println( "db_Password was mapped to byte[]" );
			
			System.out.println( "Compare input_Password with db_Password" );
			if( !Arrays.equals( input_encodedHash, db_password ) ) {
				System.out.println( "input_Password and the db_Password not the same!" );
				return buildJason( false, "Passwoerter stimmen nicht ueberein!" );
			}
			System.out.println( "input_Password and the db_Password not the same!" );
			return buildJason( true, "Passwoerter gleich und Account vorhanden!" );
		}
		catch( IOException ioEX ) {
			ioEX.printStackTrace();
		}
		return buildJason( false, "Ein unvorhergesehener Fehler ist aufgetreten!" );
	}
	private byte[] catenatePwdAndSalt( byte[] password, byte[] salt ) {
		int catenateLength = password.length + salt.length;
		
		byte[] catenateArray = new byte[ catenateLength ];
		catenateArray = ArrayUtils.addAll( password, salt );
		
		return catenateArray;
	}
	
	private byte[] encodedHash( byte[] catenateArray ) {
		byte[] encodedHash = null;
		try {
			MessageDigest digest = MessageDigest.getInstance( "SHA-256" );
			encodedHash = digest.digest( catenateArray );	
		}
		catch( NoSuchAlgorithmException ex ) {
			ex.printStackTrace();
		}
		return encodedHash;
	}
	
	private String buildJason( boolean testResult, String response ) {
		
		String jsonString = "{ testResult : " + testResult + ", response : " + response + " }"; //könnte fehlerhaft sein
		
		return jsonString;
	}
	
	public static String test;
}
