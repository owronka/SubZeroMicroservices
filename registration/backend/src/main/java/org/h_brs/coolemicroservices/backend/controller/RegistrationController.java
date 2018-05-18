package org.h_brs.coolemicroservices.backend.controller;

import org.h_brs.coolemicroservices.backend.entities.Person;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RegistrationController {
	
	@RequestMapping( method=RequestMethod.POST, value="/registration" )
	public void registration( @RequestBody String jsonInString ) {
		
		/*
		 * JASON EINGABE KONVERTIEREN ZUM JAVA OBJEKT
		 * PERSON.java
		 */
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			
			// Convert JSON string from file to Object
			Person person = mapper.readValue( jsonInString, Person.class);
			
			
		}
		catch( Exception ex ) {
			ex.printStackTrace();
		}
	}
}
