package com.smates.dbc2.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.smates.dbc2.service.MenuService;
import com.smates.dbc2.service.UserService;

public class BaseController {
	
	@Autowired
	public  UserService userService;
	
	@Autowired
	public MenuService menuService;
	
}
