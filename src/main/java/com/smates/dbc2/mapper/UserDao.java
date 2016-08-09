package com.smates.dbc2.mapper;

import com.smates.dbc2.po.User;

public interface UserDao {
	/**
	 * 根据 accountNumber查找user
	 * @param accountNumber
	 * @return user
	 */
	public User selectByAccountNumber(String accountNumber);
	
//	int deleteByPrimaryKey(String id);
//
//	int insert(User record);
//
//	int insertSelective(User record);
//
//	User selectByPrimaryKey(String id);
//
//	int updateByPrimaryKeySelective(User record);
//
//	int updateByPrimaryKey(User record);

}