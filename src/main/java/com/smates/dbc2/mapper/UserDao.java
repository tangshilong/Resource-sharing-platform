package com.smates.dbc2.mapper;

import java.util.List;

import com.smates.dbc2.po.User;
import com.smates.dbc2.vo.CostumUser;

public interface UserDao {
	/**
	 * 根据 accountNumber查找user
	 * @param accountNumber
	 * @return user
	 */
	public User selectByAccountNumber(String accountNumber);

	/**
	 * 插入新用户
	 * @param user
	 * @return
	 */
	public void insertUser(User user);

	/**
	 * 获取所有用户信息
	 * @param rows 
	 * @param page 
	 * @return
	 */
	public List<User> getAllUser(CostumUser costumUser);

	/**
	 * 获取用户数量
	 * @return
	 */
	public int getUserCount();

	/**
	 * 根据acountNumber和nickname查询User
	 * @param user
	 * @return
	 */
	public List<User> searchUser(User user);

	/**
	 * 删除user
	 * @param accountNumber
	 */
	public void deleteUser(String accountNumber);

	/**
	 * 根据用户id更新用户信息
	 * @param user2
	 */
	public void updateUser(User user2);
	
	
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