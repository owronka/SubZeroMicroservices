package com.hbrs.project.login;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hbrs.project.login.DTO.Login;

@RestController
public class RestController{



@RequestMapping("/login/web")
public Login getlogin(@RequestBody String name) {
	
	return new Login(name.getAccount(), name.getPasswordHash());
}

} 