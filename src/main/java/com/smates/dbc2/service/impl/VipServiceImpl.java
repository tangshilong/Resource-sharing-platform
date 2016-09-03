package com.smates.dbc2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.VipDao;
import com.smates.dbc2.po.Vip;
import com.smates.dbc2.service.VipService;

@Service
public class VipServiceImpl implements VipService{
	
	@Autowired
	private VipDao vipDao;

	@Override
	public List<Vip> getAllVip() {
		return vipDao.getAllVip();
	}

}
