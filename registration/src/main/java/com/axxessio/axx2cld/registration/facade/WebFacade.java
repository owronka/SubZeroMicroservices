package com.axxessio.axx2cld.registration.facade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.axxessio.axx2cld.registration.common.Security;
import com.axxessio.axx2cld.registration.facade.to.AccountTO;
import com.axxessio.axx2cld.registration.facade.to.PersonTO;
import com.axxessio.axx2cld.registration.service.RegistrationService;

@RestController
@RequestMapping("/registration/web")
public class WebFacade {
	
	@Autowired
	RegistrationService rs;
	
	private static final Logger logger = LoggerFactory.getLogger(WebFacade.class);
	
	/**
	 */
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestParam("firstname") String firstname, 
										@RequestParam("lastname") String lastname, 
										@RequestParam("username") String username, 
										@RequestParam("password") String password,
										@RequestParam("email") String email) {
		
		logger.info("create first name [" + firstname + "] - last name [" + lastname + "] - user [" + username + "] - password [" + password + "] - email [" + email + "]");
		
		PersonTO pto = new PersonTO("MR", firstname, lastname, email);

		pto.setAccount(new AccountTO(username, password, Security.generateSalt()));
		
		rs.setPerson(pto);
		
		return new ResponseEntity<PersonTO>(pto, HttpStatus.OK);
	}
}