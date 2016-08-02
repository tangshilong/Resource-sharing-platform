package com.smates.dbc2.service.impl;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtzn.code.appserver.cache.annotation.CacheKey;
import com.mtzn.code.appserver.cache.annotation.CacheRead;
import com.smates.dbc2.mapper.UserDao;
import com.smates.dbc2.po.User;
import com.smates.dbc2.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userMapper;
	
	@CacheRead(cachePrefix="getById", nameSpace = "dbc2_user")
	public User getUserById(@CacheKey String userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	public String getCurrentUserId() {
		return SecurityUtils.getSubject().getPrincipal().toString();
	}

}
