package com.hbrs.project.registration;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestController{



@RequestMapping("/registrierung")
public Registrierung registrierung(@RequestBody String name);

} 