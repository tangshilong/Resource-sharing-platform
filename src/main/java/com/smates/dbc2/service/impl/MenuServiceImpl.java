package com.smates.dbc2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.MenuDao;
import com.smates.dbc2.po.Menu;
import com.smates.dbc2.po.User;
import com.smates.dbc2.service.MenuService;
import com.smates.dbc2.service.UserService;
import com.smates.dbc2.vo.CostumMenu;

@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	private UserService userService;
	
	@Override
	public List<Menu> getMenuByRoles() {
		User user = userService.getUserById(userService.getCurrentUserId());
		return menuDao.getMenuByRole(user.getRole());
	}

	@Override
	public void addMenu(String menuName, String parentId, String menuUrl,String order,String permition) {
		Menu menu = new Menu();
		menu.setMenuId("111");
		menu.setMenuName(menuName);
		menu.setMenuUrl(menuUrl);
		menu.setOrder(Integer.parseInt(order));
		menu.setParentId(parentId);
		menu.setPermition(permition);
		menuDao.addMenu(menu);
	}

	@Override
	public List<Menu> getParentMenu() {
		return menuDao.getParentMenu();
	}

	@Override
	public List<Menu> getAllMenu(int pageNo, String menuName, String permition, int pageSize) {
		CostumMenu costumMenu = new CostumMenu();
		costumMenu.setPageNo(pageNo);
		costumMenu.setMenuName(menuName);
		costumMenu.setPermition(permition);
		costumMenu.setPageSize(pageSize);
		return menuDao.getAllMenu(costumMenu);
	}

}
