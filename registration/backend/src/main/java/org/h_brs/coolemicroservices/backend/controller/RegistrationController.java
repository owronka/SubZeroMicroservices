package org.h_brs.coolemicroservices.backend.controller;

import org.h_brs.coolemicroservices.backend.dto.Person;
import org.h_brs.coolemicroservices.backend.entities.Test;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RegistrationController {
	
	//@Autowired
	//private RegistrationService registrationService;
	
	@RequestMapping( method=RequestMethod.POST, value="/registration" )
	public void registration( @RequestBody String jsonInString ) {
		
		/*
		 * JASON EINGABE KONVERTIEREN ZUM JAVA OBJEKT
		 * PERSON.java
		 */
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			
			// Convert JSON string from file to Object
			Person newPerson = mapper.readValue( jsonInString, Person.class);
			//hier durch Person ersetzen und testen
			
			System.out.println(newPerson.getAnrede());
			System.out.println(newPerson.getUsername());
		}
		catch( Exception ex ) {
			ex.printStackTrace();
		}
		//MEhr exeptions für besseres Fehlerhandling?
		
		//registrationService.registerPerson( person );
	}
}
