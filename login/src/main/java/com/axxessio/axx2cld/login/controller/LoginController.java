package com.axxessio.axx2cld.login.controller;

import java.io.IOException;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.axxessio.axx2cld.login.repository.AccountRepository;
import com.axxessio.axx2cld.login.entities.Account;



@RestController
@RequestMapping(path="/srvc/login")
public class LoginController {
	
//	@Autowired
//	private LoginRepository loginRepository;
	@Autowired
	private AccountRepository accountRepository;

	@PostMapping("/saveAccounts")
	public String saveAccount(@RequestBody List<Account> accounts) {
		accountRepository.saveAll(accounts);
		return accounts.size() + " record saved..";
	}
	
	@GetMapping("/getAll")
	public List<Account> getAllAccounts(){
		return (List<Account>)accountRepository.findAll();
	}

	@GetMapping("/getAccountByName/{name}")
	public Account findUserbyName(@PathVariable String name) {
		return accountRepository.findByName(name);
	}
	
//localhost:8001/srvc/login/createAllData
	@GetMapping("/createAllData")
	public void createAlldata() throws IOException {
		CreateDataAtBeginning.createData();
	}
	

	//REST API um die übermittelten Daten aus dem Login ( Username & Passwort ) zu überprüfen
	//Rückgabe der erfogreichen/fehlerhaften Anmeldung
    @GetMapping(value="/verify")
    public @ResponseBody ResponseEntity<String> verify(
    		@RequestParam(value="account", defaultValue="") String account, 
    		@RequestParam(value="password", defaultValue="") String pass) {
    	
    	//Benutzer aus der Datenbank auslesen (Existiert nicht => Fehler)
    	//Passwort Hash aus Datenbank mit erzeugtem Hash vergleichen (Ungleich => fehlerhafte Anmeldedaten)
    	//sonst erfolgreich angemeldet!!
    	
    	Account actualAccount = accountRepository.findByName(account);
    	if(actualAccount!=null) {
			String actualPasswordHash = DigestUtils.sha256Hex(actualAccount.getName() +  pass + actualAccount.getSalt());
			
	    	if(actualPasswordHash.equals(actualAccount.getPasswordHash())) {
	    		
	    		return new ResponseEntity<>("Erfolgreich angemeldet!",  HttpStatus.OK);	
	        }else {
	    		return new ResponseEntity<>("Error, Falsches Passwort!", HttpStatus.UNAUTHORIZED);
	        }
    	}else {
    		return new ResponseEntity<>("Nutzer Existiert nicht!", HttpStatus.NOT_FOUND);
    	}
    	
    }
	
	
	 
	


}
