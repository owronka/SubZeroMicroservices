package org.h_brs.coolemicroservices.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.h_brs.coolemicroservices.facade.dto.PersonTO;
import org.h_brs.coolemicroservices.service.pdo.Account;
import org.h_brs.coolemicroservices.service.pdo.Address;
import org.h_brs.coolemicroservices.service.pdo.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {
	
	@PersistenceContext(unitName="Registration")
	EntityManager em;
	
	@Transactional
	public void registerPerson( PersonTO person) {
		
		System.out.println("reg service start");
		
		Person p = new Person();
		p.setAnrede(person.getSalutation());
		p.setVorname(person.getFirstname());
		p.setNachname(person.getLastname());
		
		Account a = new Account(p.getId());
		a.setEmail(person.getEmail());
		a.setBenutzer(person.getUsername());
		a.setPasswort(person.getPassword());
		
		Address ad = new Address(p.getId());
		ad.setLand(person.getCountry());
		ad.setPlz(person.getPostcode());
		ad.setOrt(person.getPlace());
		ad.setStrasse(person.getStreet());
		ad.setHausnummer(person.getHousenumber());
		
		em.persist(p);
		em.persist(a);
		em.persist(ad);
		
		System.out.println("reg service done");
	}
	

}
