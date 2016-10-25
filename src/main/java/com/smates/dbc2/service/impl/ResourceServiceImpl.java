package com.smates.dbc2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.ResourceDao;
import com.smates.dbc2.po.Resource;
import com.smates.dbc2.service.ResourceService;
import com.smates.dbc2.service.UserService;
import com.smates.dbc2.utils.SysConst;
import com.smates.dbc2.vo.CostumGame;
import com.smates.dbc2.vo.CostumResource;

@Service
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceDao resourceDao;

	@Autowired
	private UserService userService;

	@Override
	public List<Resource> getAllVip(int page, int rows, String resourceName) {
		return resourceDao.getResourceByType(new CostumResource(page, rows, resourceName, SysConst.VIP, null));
	}

	@Override
	public int countSum(String resourceName, String type) {
		return resourceDao.countSum(new CostumResource(0, 0, resourceName, type, null));
	}
	
	@Override
	public int countMyResource(String resourceName, String type) {
		return resourceDao.countMyResource(new CostumResource(0, 0, resourceName, type, userService.getCurrentUserActNum()));
	}
	
	@Override
	public List<Resource> getMyResource(int page, int rows, String type, String name) {
		return resourceDao.getMyResource(new CostumResource(page, rows, name, type, userService.getCurrentUserActNum()));
	}

	@Override
	public void deleteResource(String id) {
		resourceDao.deleteResource(id);
	}

	@Override
	public List<Resource> getAllLearn(Integer page, Integer rows, String name) {
		return resourceDao.getResourceByType(new CostumResource(page, rows, name, SysConst.LEARN, null));
	}

	@Override
	public List<Resource> getAllGame(Integer page, Integer rows, String name, String describe) {
		return resourceDao.getGameResource(new CostumGame(page, rows, name, SysConst.GAME,null,describe));
	}

	@Override
	public int countGame(String name, String describe, String type) {
		return resourceDao.countGame(new CostumGame(0, 0, name, type,null,describe));
	}

	@Override
	public String getPermitAccountNumById(int id) {
		return resourceDao.getPermitAccountNumById(id);
	}

	@Override
	public String getContentById(int id) {
		return resourceDao.getContentById(id);
	}

	@Override
	public int getIdByAccountNum(String accountNumber) {
		return resourceDao.getIdByAccountNum(accountNumber);
	}


}
