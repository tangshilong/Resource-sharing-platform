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
	 * 统计查找到记录个数
	 */
	public int countSum(String resourceName, int type);

}
