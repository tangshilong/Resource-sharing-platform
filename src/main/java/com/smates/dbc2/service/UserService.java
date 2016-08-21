package com.smates.dbc2.service;

import java.util.List;

import com.smates.dbc2.po.User;

/**
 * 用户相关service
 * 
 * @author baijw12
 *
 */
public interface UserService {

	/**
	 * 获取当前登录的用户
	 * 
	 * @return
	 */
	public String getCurrentUserId();

	/**
	 * 根据accountNumber查找user
	 * 
	 * @param accountNumber
	 * @return
	 */
	public User getUserByAccountNumber(String accountNumber);

	/**
	 * 创建用户
	 * 
	 * @param user
	 */
	public void createUser(User user);

	/**
	 * 获取所有用户信息
	 * 
	 * @param rows
	 * @param page
	 * @param nickName
	 * @param accountNumber
	 * @return
	 */
	public List<User> getAllUser(Integer page, Integer rows, String accountNumber, String nickName);

	/**
	 * 获取用户数量
	 * 
	 * @return
	 */
	public int getUserCount();

	/**
	 * 根据accountNumber删除user
	 * 
	 * @param accountNumber
	 */
	public void deleteUser(String accountNumber);

	/**
	 * 根据用户id更新用户信息
	 * 
	 * @param user2
	 *            用户信息
	 */
	public void updateUser(User user2);

}
