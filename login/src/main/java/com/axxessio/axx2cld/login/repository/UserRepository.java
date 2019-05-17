package com.axxessio.axx2cld.login.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axxessio.axx2cld.login.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

}
