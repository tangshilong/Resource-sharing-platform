package com.smates.dbc2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.MenuDao;
import com.smates.dbc2.po.Menu;
import com.smates.dbc2.po.User;
import com.smates.dbc2.service.MenuService;
import com.smates.dbc2.service.UserService;

@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	private UserService userService;
	
	@Override
	public List<Menu> getMenuByRoles() {
		User user = userService.getUserById(userService.getCurrentUserId());
		return menuDao.getAllMenu(user.getRole());
	}

	@Override
	public void addMenu(String menuName, String parentId, String menuUrl,String order) {
		Menu menu = new Menu();
		menu.setMenuId("111");
		menu.setMenuName(menuName);
		menu.setMenuUrl(menuUrl);
		menu.setOrder(Integer.parseInt(order));
		menu.setParentId(parentId);
		menuDao.addMenu(menu);
	}

}
