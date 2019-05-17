package com.axxessio.axx2cld.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axxessio.axx2cld.login.entities.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer>{
	Optional<Account> findByName(String name);

}
