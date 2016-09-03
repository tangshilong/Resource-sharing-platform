package com.smates.dbc2.mapper;

import java.util.List;

import com.smates.dbc2.po.Vip;

public interface VipDao {
	
	/**
	 * 查找a_vipResource表中所有数据
	 * @return
	 */
	public List<Vip> getAllVip(); 
	
}
