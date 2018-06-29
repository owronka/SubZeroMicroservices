package org.h_brs.coolemicroservices.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.h_brs.coolemicroservices.facade.dto.AccountTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {
	@PersistenceContext(unitName="Registration")
	EntityManager em;
	
	@Transactional
	public AccountTO getAccount() {
		
		//TODO: Rueckgabe hinzufuegen
		return null;
		
	}
}
