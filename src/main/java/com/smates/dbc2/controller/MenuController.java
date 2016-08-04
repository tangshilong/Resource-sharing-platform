package com.smates.dbc2.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("admin")
@Controller
public class MenuController extends BaseController{
	
	public Logger logger = Logger.getLogger(MenuController.class);
	
	@RequestMapping(value="addMenu",method=RequestMethod.GET)
	public String loadAddMenu(ModelMap modelMap){
		logger.info(menuService.getParentMenu().size());
		modelMap.addAttribute("parentMenu", menuService.getParentMenu());
		return "saveMenu.ftl";
	}
	
	@RequestMapping(value="addMenu",method=RequestMethod.POST)
	public String addMenu(String menuName, String menuUrl, String parentId, String orderNo, String permition){
		menuService.addMenu(menuName, parentId, menuUrl, orderNo, permition);
		return "saveMenu.ftl";
	}
	
}
