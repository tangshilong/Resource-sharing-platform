package com.smates.dbc2.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smates.dbc2.po.Menu;
import com.smates.dbc2.vo.BaseMsg;
import com.smates.dbc2.vo.ComboBoxRow;
import com.smates.dbc2.vo.DataGrideRow;

@RequestMapping("admin")
@Controller
public class MenuController extends BaseController{
	
	public Logger logger = Logger.getLogger(MenuController.class);
	
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
	public BaseMsg addMenu(String menuName, String menuUrl, String parentId, String order, String permition){
		logger.info("父菜单ID:"+parentId);
		logger.info("添加菜单项");
		menuService.addMenu(menuName, parentId, menuUrl, order, permition);
		logger.info("添加菜单项成功");
		return new BaseMsg(true, "菜单添加成功");
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
	public DataGrideRow getAllMenu(@RequestParam(defaultValue = "1") int page, String menuName, String permition, int rows){
		logger.info("获取所有菜单项");
		List<Menu> menus = menuService.getAllMenu(page,menuName,permition,rows);
		return new DataGrideRow(menuService.countSum(), menus);
	}
	
	/**
	 * 获取所有一级菜单
	 * @return
	 */
	@RequestMapping("getParentMenu")
	@ResponseBody
	public List<ComboBoxRow> getParentMenu(){
		logger.info("获取所有一级菜单");
		List<ComboBoxRow> comboBoxRows =  menuService.getParentMenu();
		comboBoxRows.add(new ComboBoxRow("0","无"));//添加无上级菜单选项
		return comboBoxRows;
	}
	
}
