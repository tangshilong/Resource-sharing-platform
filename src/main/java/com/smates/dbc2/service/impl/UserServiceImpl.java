package com.smates.dbc2.service.impl;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.UserDao;
import com.smates.dbc2.po.User;
import com.smates.dbc2.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userMapper;
	
//	@Override
//	public User getUserById(String userId) {
//		return userMapper.selectByPrimaryKey(userId);
//	}

	@Override
	public String getCurrentUserId() {
		return SecurityUtils.getSubject().getPrincipal().toString();
	}

	@Override
	public User getUserByAccountNumber(String accountNumber) {
		return userMapper.selectByAccountNumber(accountNumber);
	}

}
