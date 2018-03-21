package com.project.service;

import com.project.model.User;

public interface UserServiceImp {
	void save(User user);
	
	User findByUsername(String username);
}
