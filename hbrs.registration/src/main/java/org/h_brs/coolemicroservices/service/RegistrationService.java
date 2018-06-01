package org.h_brs.coolemicroservices.service;

import org.h_brs.coolemicroservices.facade.dto.PersonTO;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
	
	public void registerPerson( PersonTO person) {
		
		
		//hier dann gucken ob Pflichtangaben gemacht etc
		//eventuell email überprüfen mit lambda expressions etc
		//dann erst in Db speichern
		
		//was ist mit EXception handling für User?
		
	}

}
