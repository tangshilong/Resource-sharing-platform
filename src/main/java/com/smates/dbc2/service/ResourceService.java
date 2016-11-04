package com.smates.dbc2.service;

import java.util.Date;
import java.util.List;

import com.smates.dbc2.po.Resource;

/**
 * 资源相关service
 * 
 * @author baijw12
 *
 */
public interface ResourceService {

	/**
	 * 获取某一类资源
	 * 
	 * @return
	 */
	public List<Resource> getAllVip(int page, int rows, String resourceName);

	/**
	 * 统计查找到某类资源记录个数
	 */
	public int countSum(String resourceName, String type);

	/**
	 * 统计查到游戏资源个数
	 * 
	 * @param name
	 * @param describe
	 * @param game
	 * @return
	 */
	public int countGame(String name, String describe, String type);

	/**
	 * 统计某个用户资源个数
	 * 
	 * @return
	 */
	public int countMyResource(String resourceName, String type);

	/**
	 * 查找某个用户的资源
	 * 
	 * @param accountNum
	 *            当前登录用户用户名
	 * @return
	 */
	public List<Resource> getMyResource(int page, int rows, String type, String name);

	/**
	 * 删除一个资源
	 * 
	 * @param id
	 *            资源id
	 */
	public void deleteResource(String id);

	/**
	 * 获取符合条件的learn资源
	 * 
	 * @param page
	 * @param rows
	 * @param name
	 * @return
	 */
	public List<Resource> getAllLearn(Integer page, Integer rows, String name);

	/**
	 * 获取符合条件的game资源
	 * 
	 * @param page
	 * @param rows
	 * @param name
	 * @param descirbe
	 * @return
	 */
	public List<Resource> getAllGame(Integer page, Integer rows, String name, String descirbe);

	/**
	 * 根据资源id查找有权限的账户
	 * 
	 * @param id
	 * @return
	 */
	public String getPermitAccountNumById(int id);

	/**
	 * 根据资源id获得内容
	 * 
	 * @param id
	 */
	public String getContentById(int id);

	/**
	 * 根据账号获取id
	 * 
	 * @param accountNumber
	 * @return
	 */
	public int getIdByAccountNum(String accountNumber);

	/**
	 * 用户上传资源
	 * 
	 * @param resource
	 */
	public void addResource(String type, String name, String content, String describe, String owner,
			Date createTime, String url, String permitAccountNum);

}
