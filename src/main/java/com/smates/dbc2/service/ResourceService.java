package com.smates.dbc2.service;

import java.util.List;

import com.smates.dbc2.po.Resource;

/**
 * 资源相关service
 * @author baijw12
 *
 */
public interface ResourceService {
	
	/**
	 * 获取某一类资源
	 * @return
	 */
	public List<Resource> getAllVip(int page, int rows, String resourceName);
	
	/**
	 * 统计查找到某类资源记录个数
	 */
	public int countSum(String resourceName, String type);
	
	/**
	 * 统计查到游戏资源个数
	 * @param name
	 * @param describe
	 * @param game
	 * @return
	 */
	public int countGame(String name, String describe, String type);
	
	/**
	 * 统计某个用户资源个数
	 * @return
	 */
	public int countMyResource(String resourceName, String type); 

	/**
	 * 查找某个用户的资源
	 * @param accountNum 当前登录用户用户名
	 * @return
	 */
	public List<Resource> getMyResource(int page, int rows, String type, String name);
	
	/**
	 * 删除一个资源
	 * @param id 资源id
	 */
	public void deleteResource(String id);

	/**
	 * 获取符合条件的learn资源
	 * @param page
	 * @param rows
	 * @param name
	 * @return
	 */
	public List<Resource> getAllLearn(Integer page, Integer rows, String name);

	/**
	 * 获取符合条件的game资源
	 * @param page
	 * @param rows
	 * @param name
	 * @param descirbe
	 * @return
	 */
	public List<Resource> getAllGame(Integer page, Integer rows, String name, String descirbe);

	

}
