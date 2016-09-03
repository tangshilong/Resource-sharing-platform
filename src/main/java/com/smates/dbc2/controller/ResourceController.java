package com.smates.dbc2.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smates.dbc2.po.Resource;
import com.smates.dbc2.utils.SysConst;
import com.smates.dbc2.vo.DataGrideRow;

@Controller
public class ResourceController extends BaseController{
	
	private Logger logger = Logger.getLogger(ResourceController.class);
	
	@RequestMapping(value="getAllVip",method=RequestMethod.GET)
	@ResponseBody
	public DataGrideRow<Resource> getAllVip(@RequestParam(defaultValue = "1") int page, int rows, String name){
		logger.info("访问vip账号资源");
		logger.info(page+","+rows+","+name);
		return new DataGrideRow<Resource>(resourceService.countSum(name, SysConst.VIP), resourceService.getAllVip(page,rows,name));
	}
	
}
