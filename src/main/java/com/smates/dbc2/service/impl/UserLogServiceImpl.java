package com.smates.dbc2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.dao.UserLogDao;
import com.smates.dbc2.po.UserLog;
import com.smates.dbc2.service.UserLogService;

@Service
public class UserLogServiceImpl implements UserLogService{

	@Autowired
	private UserLogDao userLogDao;
	
	@Override
	public void addUserLog(UserLog userLog) {
		userLogDao.insert(userLog);
	}

}
