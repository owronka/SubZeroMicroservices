package com.hbrs.project.login;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestController{



@RequestMapping("/login")
public Login login(@RequestBody String name);

} 