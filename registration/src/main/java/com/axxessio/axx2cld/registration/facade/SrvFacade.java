package com.axxessio.axx2cld.registration.facade;


//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.axxessio.axx2cld.registration.common.Helper;
import com.axxessio.axx2cld.registration.facade.to.AddressTO;
import com.axxessio.axx2cld.registration.facade.to.PersonTO;
import com.axxessio.axx2cld.registration.facade.to.UserTO;
import com.axxessio.axx2cld.registration.service.RegistrationService;
import com.axxessio.axx2cld.registration.service.pdo.Person;

@RestController
@RequestMapping("/registration/srv")
public class SrvFacade {
	
	@Autowired
	RegistrationService rs;
	
	private static final Logger logger = LoggerFactory.getLogger(WebFacade.class);
	
	/**
	 */
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public ResponseEntity<?> getUser(@RequestParam("aspects") String aspects,
									 @RequestParam("version") String version) {
		long maxVersion=0;
		
		PersonTO [] ptos = null;
		UserTO uto = null;
		
		logger.info("read data for aspects [" + aspects + "] and version  [" + version + "]");
		
		if (!Helper.isEmpty(version)) {
			List<Person> persons = rs.getPerson(Long.parseLong(version));
		
			if (persons.size() == 0) {
				return new ResponseEntity<UserTO>(new UserTO(Long.parseLong(version), ptos), HttpStatus.OK);
			} else {
				ptos = new PersonTO[persons.size()];

				for (int i = 0; i < persons.size(); i++) {
					Person p = persons.get(i);
					
					ptos [i] = p.getPerson();

					if(p.getVersion() > maxVersion) maxVersion = p.getVersion();
					
					if (!Helper.isEmpty(aspects)) {
						if (aspects.toLowerCase().indexOf("account") > 0) {
							if (p.getAccount() != null) {
								ptos [i].setAccount(p.getAccount().get(0).getAccount());
							}
						}
						if (aspects.toLowerCase().indexOf("address") > 0) {
							if (p.getAddress() != null) {
								AddressTO[] adTOs = new AddressTO[p.getAddress().size()];
								
								for (int j = 0; j < p.getAddress().size(); j++) {
									adTOs[j] = p.getAddress().get(j).getAddress();
								}
								
								ptos [i].setAddress(adTOs);
							}
						}
					}
					
					if (i == 99) {
						uto = new UserTO(maxVersion, ptos);
				
						//uto.add(linkTo(methodOn(SrvFacade.class).getUser(aspects, version)).withSelfRel());

						return new ResponseEntity<UserTO>(uto, HttpStatus.OK);						
					}
				}
			}
		}		
		uto = new UserTO(maxVersion, ptos);

		//uto.add(linkTo(methodOn(SrvFacade.class).getUser(aspects, version)).withSelfRel());

		return new ResponseEntity<UserTO>(uto, HttpStatus.OK);						
	}
}