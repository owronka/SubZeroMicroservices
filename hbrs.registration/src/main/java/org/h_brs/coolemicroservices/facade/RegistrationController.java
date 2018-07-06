package org.h_brs.coolemicroservices.facade;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;
import org.h_brs.coolemicroservices.facade.dto.PersonTO;
import org.h_brs.coolemicroservices.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class RegistrationController {
	
	private byte[] salt = null;
	
	@Autowired
	private RegistrationService registrationService;
	
	@RequestMapping( method=RequestMethod.POST, value="/registration/srv" )
	public void registration( @RequestBody String jsonInString ) {
		
		/*
		 * JASON EINGABE KONVERTIEREN ZUM JAVA OBJEKT
		 * PERSONTO.java
		 */
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			// Convert JSON string from file to Object
			PersonTO personTO = mapper.readValue( jsonInString, PersonTO.class );
			//Konsolenausgabe
			System.out.println( "/**************************\n"
							  + "RegistrationController.java\n\\n"
							  + "Json input: \n" + jsonInString + "\n\\nconverted to:\n\\n" + personTO.toString()
							  + "\n**************************/");
			
			System.out.println( "Try to put Password into ByteArray" );
			byte[] password = personTO.getPassword().getBytes( StandardCharsets.UTF_8 );
			personTO.setPassword( null );
			System.out.println( "Password was put into ByteArray and set to NULL" );
			
			
			System.out.println( "Try to generate Salt" );
			setSalt();
			System.out.println( "Salt was generated" );

			System.out.println( "Call RegistrationService" );
			registrationService.registerPerson( personTO, salt, encodedHash( catenatePwdAndSalt( password, salt ) ) );			
		}
		catch( IOException ioEX ) {
			ioEX.printStackTrace();
		}
	}
	
	private void setSalt() {
		final Random randomizer = new SecureRandom();
		byte[] saltArray = new byte[32];
		randomizer.nextBytes( saltArray );
		salt = saltArray;
	}
	
	private byte[] catenatePwdAndSalt( byte[] password, byte[] salt ) {
		int catenateLength = password.length + salt.length;
		
		byte[] catenateArray = new byte[ catenateLength ];
		catenateArray = ArrayUtils.addAll( password , salt );
		
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
}
