package org.h_brs.coolemicroservices.facade;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
	
	@Autowired
	private RegistrationService registrationService;
	
	@RequestMapping( method=RequestMethod.POST, value="/registration/srv" )
	public void registration( @RequestBody String jsonInString ) {
		
		System.out.println(jsonInString);
		/*
		 * JASON EINGABE KONVERTIEREN ZUM JAVA OBJEKT
		 * PERSON.java
		 */
		String decodedString = null;
		try {
			decodedString = java.net.URLDecoder.decode(jsonInString, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			// Convert JSON string from file to Object
			PersonTO personTO = mapper.readValue( decodedString, PersonTO.class );
			//Konsolenausgabe
			System.out.println( "/**************************\n"
							  + "RegistrationController.java\n"
							  + "Json input: \n" + decodedString + "\nconverted to:\n" + personTO.toString()
							  + "\n**************************/");
			
			registrationService.registerPerson( personTO );
		}
		catch( IOException ioEX ) {
			ioEX.printStackTrace();
		}
	}
}
