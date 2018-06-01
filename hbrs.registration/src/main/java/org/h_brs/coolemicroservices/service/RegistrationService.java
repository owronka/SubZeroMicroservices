package org.h_brs.coolemicroservices.service;

import org.h_brs.coolemicroservices.facade.dto.PersonTO;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
	
	public void registerPerson( PersonTO person ) {
		
		System.out.println( person.getSalutation() );
		
		System.out.println( person.getFirstname() );
		
		System.out.println( person.getLastname() );
		
		System.out.println( person.getEmail() );
		
		System.out.println( person.getUsername() );
		
		System.out.println( person.getPassword() );
		
//		System.out.println( person.getCountry() );
//		
//		System.out.println( person.getPostcode() );
//		
//		System.out.println( person.getPlace() );
//		
//		System.out.println( person.getStreet() );
//		
//		System.out.println( person.getHousenumber() );
		
		//hier dann gucken ob Pflichtangaben gemacht etc
		//eventuell email überprüfen mit lambda expressions etc
		//dann erst in Db speichern
		
		//was ist mit EXception handling für User?
		
	}

}
