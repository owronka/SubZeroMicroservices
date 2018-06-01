package com.axxessio.axx2cld.registration.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.axxessio.axx2cld.registration.common.Security;
import com.axxessio.axx2cld.registration.facade.to.PersonTO;
import com.axxessio.axx2cld.registration.service.pdo.Account;
import com.axxessio.axx2cld.registration.service.pdo.Person;
import com.axxessio.axx2cld.registration.service.pdo.Version;

@Service
public class RegistrationService {

	@PersistenceContext(unitName="Registration")
	EntityManager em;
	
	private static final Logger logger = LoggerFactory.getLogger(RegistrationService.class);

	public List<Person> getPerson(long version) {
		List<Person> persons = null;
		Query query;
		
		query = em.createNamedQuery("Person.findByVersion");
		query.setParameter(1, version);

		try {
			persons = (List<Person>) query.getResultList();
		} catch (Exception e) {
			logger.warn("Problem - can not find any person for version [" + version + "] in the database.", e);
		}
		
		return persons;
	}

	@Transactional
	public Person setPerson(PersonTO pto) {
		long version = Version.getNextVersion(em);
		
		// Secure random salt
		String salt = Security.generateSalt();
		// hashed password
		String genPassword = Security.getSaltedPwdHash(pto.getAccount().getPwdHash(), salt);
		// String genPassword = generateSha2(password);

		Person p = new Person(pto, version);
		
		em.persist(p);

		if (pto.getAccount() != null) {
			Account ac = new Account (pto.getAccount(), genPassword, salt);

			ac.setPerson(p);
			
			em.persist(ac);
		}

		return p;
	}
}
