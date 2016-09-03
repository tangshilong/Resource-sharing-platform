package com.smates.dbc2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.ResourceDao;
import com.smates.dbc2.po.Resource;
import com.smates.dbc2.service.ResourceService;
import com.smates.dbc2.utils.SysConst;
import com.smates.dbc2.vo.CostumResource;

@Service
public class ResourceServiceImpl implements ResourceService{
	
	@Autowired
	private ResourceDao resourceDao;

	@Override
	public List<Resource> getAllVip(int page, int rows, String resourceName) {
		return resourceDao.getResourceByType(new CostumResource(page,rows,resourceName,SysConst.VIP));
	}

	@Override
	public int countSum(String resourceName, int type) {
		return resourceDao.countSum(new CostumResource(0, 0, resourceName, type));
	}

}
