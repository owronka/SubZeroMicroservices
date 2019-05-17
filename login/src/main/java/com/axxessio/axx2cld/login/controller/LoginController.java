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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.axxessio.axx2cld.login.entities.Account;
import com.axxessio.axx2cld.login.entities.Login;
import com.axxessio.axx2cld.login.entities.User;
import com.axxessio.axx2cld.login.repository.AccountRepository;
import com.axxessio.axx2cld.login.repository.LoginRepository;
import com.axxessio.axx2cld.login.repository.UserRepository;


@RestController
@RequestMapping(path="/login")
public class LoginController {
	@Autowired
	//private UserRepository userRepository;
	private UserRepository userRepository;
	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping// Map ONLY GET Requests
	public @ResponseBody List<User> getAllUser () {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		List<User> userL = new ArrayList<>();
		
		this.userRepository.findAll().forEach(User -> {
			userL.add(User);
		});
		return userL;
	}
	
	@GetMapping("/{email}")
	public @ResponseBody User getUserByEmail(@PathVariable(value="email") String email){
		Optional<User> user = this.userRepository.findById(email);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}
	
	@PostMapping
	public @ResponseBody User addUser(@RequestBody(required = true) User user) {
		return this.userRepository.save(user);
		
	}
	
	@DeleteMapping("/{email}")
	public @ResponseBody boolean deleteUser(@PathVariable(value="email") String email) {
		Optional<User> user = this.userRepository.findById(email);
		if(user.isPresent()) {
			this.userRepository.delete(user.get());
			return true;
		}
		return false;
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
