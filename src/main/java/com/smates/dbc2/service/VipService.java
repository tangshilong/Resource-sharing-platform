package com.smates.dbc2.service;

import java.util.List;

import com.smates.dbc2.po.Vip;

/**
 * vip相关service
 * @author baijw12
 *
 */
public interface VipService {
	
	/**
	 * 获取所有vip账号
	 * @return vip账号list
	 */
	public List<Vip> getAllVip();

}
