package com.smates.dbc2.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smates.dbc2.po.Menu;
import com.smates.dbc2.vo.BaseMsg;
import com.smates.dbc2.vo.Rows;

@RequestMapping("admin")
@Controller
public class MenuController extends BaseController{
	
	public Logger logger = Logger.getLogger(MenuController.class);
	
	/**
	 * 访问此uri,返回menu页面
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="addMenu",method=RequestMethod.GET)
	public String loadAddMenu(ModelMap modelMap){
		logger.info("加载menu页面");
		modelMap.addAttribute("parentMenu", menuService.getParentMenu());
		return "Menu.ftl";
	}
	
	/**
	 * 添加菜单项
	 * @param menuName 菜单名称
	 * @param menuUrl 菜单url
	 * @param parentId 父菜单id
	 * @param orderNo 菜单排序号
	 * @param permition 菜单权限
	 * @return 是否添加成功,以及反馈信息
	 */
	@RequestMapping(value="addMenu",method=RequestMethod.POST)
	@ResponseBody
	public BaseMsg addMenu(String menuName, String menuUrl, String parentId, String orderNo, String permition){
		logger.info("添加菜单项");
		menuService.addMenu(menuName, parentId, menuUrl, orderNo, permition);
		logger.info("添加菜单项成功");
		return new BaseMsg(true, "success");
	}
	
	/**
	 * 按条件查询菜单
	 * @param page 当前页数
	 * @param menuName 菜单名称
	 * @param permition 菜单权限
	 * @param rows 每页的记录条数
	 * @return easyUI格式的json
	 */
	@RequestMapping(value="getAllMenu",method=RequestMethod.GET)
	@ResponseBody
	public Rows getAllMenu(@RequestParam(defaultValue = "1") int page, String menuName, String permition, int rows){
		logger.info(page+","+rows);
		logger.info("获取所有菜单项");
		List<Menu> menus = menuService.getAllMenu(page,menuName,permition,rows);
		logger.info(menus.size());
		return new Rows(menuService.countSum(), menus);
	}
	
	/**
	 * 获取所有一级菜单
	 * @return
	 */
//	@RequestMapping("getParentMenu")
//	@ResponseBody
//	public Rows getParentMenu(){
//		logger.info("获取所有一级菜单");
//		return rows;
//	}
	
}
