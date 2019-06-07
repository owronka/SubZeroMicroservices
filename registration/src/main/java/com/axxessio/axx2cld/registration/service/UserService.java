package com.axxessio.axx2cld.registration.service;

import com.axxessio.axx2cld.registration.entities.User;

public interface UserService {
	public void save (User user);
	public User findByUsername (String username);
}
