package org.h_brs.coolemicroservices.service;

import org.h_brs.coolemicroservices.facade.dto.Person;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
	
	public void registerPerson( Person person) {
		
		
		//hier dann gucken ob Pflichtangaben gemacht etc
		//eventuell email überprüfen mit lambda expressions etc
		//dann erst in Db speichern
		
		//was ist mit EXception handling für User?
		
	}

}
