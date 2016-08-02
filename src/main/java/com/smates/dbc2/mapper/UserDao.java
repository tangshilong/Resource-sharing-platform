package com.smates.dbc2.mapper;

import org.springframework.stereotype.Service;

import com.smates.dbc2.po.User;

@Service
public interface UserDao {
	int deleteByPrimaryKey(String id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
}