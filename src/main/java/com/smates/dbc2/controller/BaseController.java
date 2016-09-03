package com.smates.dbc2.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.smates.dbc2.qniu.QniuHelper;
import com.smates.dbc2.service.MenuService;
import com.smates.dbc2.service.RoleService;
import com.smates.dbc2.service.UserService;
import com.smates.dbc2.service.impl.VipServiceImpl;

public class BaseController {
	
	@Autowired
	public QniuHelper qniuHelper;
	
	@Autowired
	public  UserService userService;
	
	@Autowired
	public MenuService menuService;
	
	@Autowired
	public RoleService roleService;
	
	@Autowired
	public VipServiceImpl vipServiceImpl;
	
}
