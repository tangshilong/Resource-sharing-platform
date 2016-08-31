package com.smates.dbc2.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smates.dbc2.dao.UserLogDao;
import com.smates.dbc2.mongo.DbHelper;
import com.smates.dbc2.po.UserLog;

@Component
public class UserLogDaoImpl implements UserLogDao {

	@Autowired
	private DbHelper db;

	@Override
	public void insert(UserLog userLog) {
		db.getDs().save(userLog);
	}

}