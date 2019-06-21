package com.axxessio.axx2cld.registration.service;

import com.axxessio.axx2cld.registration.entities.User;
import com.axxessio.axx2cld.registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
  
   
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        UserRepository.save(user);
    }

    public User findByUsername(String username) {
        return UserRepository.findByUsername(username);
    }
}