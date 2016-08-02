package com.smates.dbc2.service;

import com.smates.dbc2.po.User;

public interface UserService {
	
	public User getUserById(String userId);
	
	public String getCurrentUserId();
}
