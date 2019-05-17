package com.axxessio.axx2cld.login;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.axxessio.axx2cld.login.entities.Account;
import com.axxessio.axx2cld.login.entities.Login;
import com.axxessio.axx2cld.login.repository.AccountRepository;
import com.axxessio.axx2cld.login.repository.LoginRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginTest {
	
	@Autowired
	private LoginRepository loginRepo;
	
	@Autowired
	private AccountRepository accountRepo;
	
	@Before
	public void setUp() {
		
	}
	
//	@Test
//	public void testCreate() {
//		Account account = new Account();
//		account.setName("Test");
//		account.setPasswortdHash("#jjd");
//		account.setPersonId(2);
//		account.setSalt("xyz");
//		Account createdAccount = this.accountRepo.save(account);
//		assertEquals(account.getName(), createdAccount.getName());
//		
//	}

	@Test
	public void testRead() {
		
		Account account = new Account();
		account.setName("Test");
		account.setPasswortdHash("#jjd");
		account.setPersonId(2);
		account.setSalt("xyz");
		
		Login login = new Login();
		
		account.setLogin(login);
		
		Account savedAccount = this.accountRepo.save(account);
		
		Login  foundLogin = this.loginRepo.findByAccount(savedAccount).get();
		
		assertEquals(account.getSalt(), foundLogin.getSalt());
		assertEquals(account.getPasswortdHash(), foundLogin.getPasswordHash());
		assertEquals(account.getName(), foundLogin.getAccountName());
		
	}
}
