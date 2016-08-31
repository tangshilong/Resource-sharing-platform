package com.smates.dbc2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.MenuDao;
import com.smates.dbc2.mencache.annotation.CacheClear;
import com.smates.dbc2.mencache.annotation.CacheKey;
import com.smates.dbc2.mencache.annotation.CacheRead;
import com.smates.dbc2.po.Menu;
import com.smates.dbc2.po.User;
import com.smates.dbc2.service.MenuService;
import com.smates.dbc2.service.UserService;
import com.smates.dbc2.vo.ComboBoxRow;
import com.smates.dbc2.vo.CostumMenu;
import com.smates.dbc2.vo.MenuCheckboxVo;

@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	private UserService userService;
	
	@Override
	public List<Menu> getMenuByRoles() {
		User user = userService.getUserByAccountNumber(userService.getCurrentUserId());
		return menuDao.getMenuByRole(user.getRole());
	}

	@Override
	@CacheClear(nameSpace="menu")
	public void addMenu(String menuName, String parentId, String menuUrl,Integer order,String permition) {
		Menu menu = new Menu();
		menu.setMenuId("111");
		menu.setMenuName(menuName);
		menu.setMenuUrl(menuUrl);
		menu.setOrder(order);
		menu.setParentId(parentId);
		menu.setPermition(permition);
		menuDao.addMenu(menu);
	}

	@Override
	public List<ComboBoxRow> getParentMenu() {
		return menuDao.getParentMenu();
	}

	@Override
	@CacheRead(nameSpace="menu",cachePrefix="getAll")
	public List<Menu> getAllMenu(@CacheKey int pageNo,@CacheKey  String menuName,@CacheKey  String permition,@CacheKey  int pageSize) {
		CostumMenu costumMenu = new CostumMenu();
		costumMenu.setStartCount((pageNo-1)*pageSize);
		costumMenu.setMenuName(menuName);
		costumMenu.setPermition(permition);
		costumMenu.setPageSize(pageSize);
		return menuDao.getAllMenu(costumMenu);
	}

	@Override
	public int countSum() {
		return menuDao.countSum();
	}

	@Override
	@CacheClear(nameSpace="menu")
	public void deleteMenuById(String menuId) {
		menuDao.deleteMenuById(menuId);
	}

	@Override
	public Menu getMenuById(String menuId) {
		return menuDao.getMenuById(menuId);
	}

	@Override
	@CacheClear(nameSpace="menu")
	public void updateMenu(String menuId, String menuName, String menuUrl, String parentId, Integer order,
			String permition) {
		menuDao.updateMenu(new Menu(menuId, menuName, parentId, menuUrl, order, permition, null));
	}
	
	@Override
	public MenuCheckboxVo formatePo(Menu menu) {
		MenuCheckboxVo menuCheckboxVo = new MenuCheckboxVo();
		menuCheckboxVo.setMenuId(menu.getMenuId());
		menuCheckboxVo.setMenuName(menu.getMenuName());
		menuCheckboxVo.setMenuUrl(menu.getMenuUrl());
		menuCheckboxVo.setOrder(menu.getOrder());
		menuCheckboxVo.setParentId(menu.getParentId());
		menuCheckboxVo.setSubmenus(menu.getSubmenus());
		menuCheckboxVo.setPermition(menu.getPermition().split(","));
		return menuCheckboxVo;
	}

}
