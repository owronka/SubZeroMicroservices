package com.axxessio.axx2cld.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.axxessio.axx2cld.login.entities.Account;
import com.axxessio.axx2cld.login.entities.Login;

public interface LoginRepository extends CrudRepository<Login, Integer>{
	//Optional<Login> findby

	//Optional<Login> findByAccount(String account);
	Optional<Login> findByAccount(Account account);
}


