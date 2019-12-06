package com.hbrs.project.registration;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController{



@RequestMapping("/registration/web")
public Registration getRegistration(@RequestBody Registration stats ) {
	return new Registration(stats.getAnrede(), stats.getVorname(), stats.getName()
			,stats.getEmail() ,stats.getBenutzer() , stats.getPw() ,stats.getPwhl() , stats.getPlz() , stats.getStadt()
			, stats.getStrasse() , stats.getHnummer());
} 
}