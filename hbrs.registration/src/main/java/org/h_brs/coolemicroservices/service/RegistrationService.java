package org.h_brs.coolemicroservices.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.h_brs.coolemicroservices.facade.dto.PersonTO;
import org.h_brs.coolemicroservices.service.pdo.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {
	
	@PersistenceContext(unitName="Registration")
	EntityManager em;
	
	@Transactional
	public void registerPerson( PersonTO person) {
		
		Person p = new Person();
		p.setAnrede(person.getSalutation());
		p.setVorname(person.getFirstname());
		p.setNachname(person.getLastname());
		
		Account a = new Account();
		a.setEmail(person.getEmail());
		a.setUsername(person.getUsername());
		a.setPassword(person.getPassword());
		a.setPerson(p.getId());
		
		Address ad = new Address();
		ad.setLand(person.getCountry());
		ad.setPlz(person.getPostcode());
		ad.setOrt(person.getPlace());
		ad.setStrasse(person.getStreet());
		ad.setHausnummer(person.getHousenumber());
		ad.setPerson(p.getId());
		
		em.persist(p);
		em.persist(a);
		em.persist(ad);
	}
	

}
