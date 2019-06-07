package com.axxessio.axx2cld.registration.repository;

import com.axxessio.axx2cld.registration.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository {
   public User findByUsername(String username);
}