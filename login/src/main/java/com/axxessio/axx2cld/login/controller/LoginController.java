package com.axxessio.axx2cld.login.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.axxessio.axx2cld.login.entities.Account;
import com.axxessio.axx2cld.login.entities.Login;
import com.axxessio.axx2cld.login.repository.AccountRepository;
import com.axxessio.axx2cld.login.repository.LoginRepository;


@RestController
@RequestMapping(path="/srvc/login")
public class LoginController {
	
	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private AccountRepository accountRepository;
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Boolean> login(@RequestParam(name="account") String account, 
										@RequestParam(name="password") String password){
		Optional<Account> foundaccount = this.accountRepository.findByName(account);
		if(foundaccount.isPresent()) {
			Optional<Login> login = this.loginRepository.findByAccount(foundaccount.get());
			Login loginFound = login.get();
			if(account.equals(loginFound.getAccountName())&& password.equals(loginFound.getPasswordHash())) {
				
			
			return new ResponseEntity<>(true,HttpStatus.OK);
			}else {
				return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);

			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
//	@GetMapping("/{account}")
//	public @ResponseBody ResponseEntity<Login> readLogin(@PathVariable(value="account") String account) {
//		Optional<Login> login = this.loginRepository.findByAccount(account);
//		if(login.isPresent()) {
//			return new ResponseEntity<Login>(login.get(),HttpStatus.OK);
//			
//		}
//		return new ResponseEntity<Login>(HttpStatus.NOT_FOUND);
//		
//	}
	
	@PostMapping("/account")
	public @ResponseBody Account addAccount(@RequestBody(required = true) Account account) {
		Login login = new Login();
		account.setLogin(login);
		//Account newAccount = new Account(account.getPersonId(), account.getName(), account.getPasswortdHash(), account.getSalt(), login);
		//login.setAccount(newAccount);
		return this.accountRepository.save(account);
		
	}
	@GetMapping("/account/{name}")
	public @ResponseBody ResponseEntity<Account> readAccountByName(@PathVariable(value="name") String name) {
		
		Optional<Account> foundaccount = this.accountRepository.findByName(name);
		if(foundaccount.isPresent()) {
			return new ResponseEntity<Account>(foundaccount.get(),HttpStatus.OK);
			
		}
		return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/login/{name}")
	public @ResponseBody ResponseEntity<Login> readLogin(@PathVariable(value="name") String name) {
		
		Optional<Account> foundaccount = this.accountRepository.findByName(name);
		if(foundaccount.isPresent()) {
			Optional<Login> login = this.loginRepository.findByAccount(foundaccount.get());
			return new ResponseEntity<>(login.get(),HttpStatus.OK);
			
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	 
	


}
