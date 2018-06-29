package org.h_brs.coolemicroservices.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.h_brs.coolemicroservices.facade.dto.AccountTO;
import org.h_brs.coolemicroservices.services.pdo.Account;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {
	@PersistenceContext(unitName="Registration")
	EntityManager em;
	
	@Transactional
	public Account getAccount(String email) {
		
		javax.persistence.Query query = em.createNamedQuery("Account.findAccountByName");
		query.setParameter(0, email);
		
		Account acc = null;
		
		try {
			acc = (Account) query.getSingleResult();		
		}catch(Exception e) {
			System.out.println("Kein Account mit der EMail vorhanden: "+email);
		}
		
		return acc;
		
	}
}
