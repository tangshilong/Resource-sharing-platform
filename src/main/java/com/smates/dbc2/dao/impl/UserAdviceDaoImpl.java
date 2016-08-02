package com.smates.dbc2.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smates.dbc2.dao.UserAdviceDao;
import com.smates.dbc2.mongo.DbHelper;
import com.smates.dbc2.po.UserAdvice;

@Component
public class UserAdviceDaoImpl implements UserAdviceDao {

	@Autowired
	private DbHelper db;

	@Override
	public void insert(UserAdvice userAdvice) {
		db.getDs().save(userAdvice);
	}

}