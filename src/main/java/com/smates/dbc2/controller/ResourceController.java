package com.smates.dbc2.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smates.dbc2.po.Resource;
import com.smates.dbc2.utils.SysConst;
import com.smates.dbc2.vo.BaseMsg;
import com.smates.dbc2.vo.DataGrideRow;

@Controller
public class ResourceController extends BaseController{
	
	private Logger logger = Logger.getLogger(ResourceController.class);
	
	/**
	 * 获取符合条件的vip账号资源
	 * @param page 当前页数
	 * @param rows 每页记录数
	 * @param name 查询条件,资源名称
	 * @return
	 */
	@RequestMapping(value="getAllVip",method=RequestMethod.GET)
	@ResponseBody
	public DataGrideRow<Resource> getAllVip(@RequestParam(defaultValue = "1") Integer page, Integer rows, String name){
		logger.info("访问vip账号资源");
		logger.info(page+","+rows+","+name);
		return new DataGrideRow<Resource>(resourceService.countSum(name, SysConst.VIP), resourceService.getAllVip(page,rows,name));
	}
	
	/**
	 * 获取当前登录用户上传的资源
	 * @return
	 */
	@RequestMapping(value="getMyResource",method=RequestMethod.GET)
	@ResponseBody
	public DataGrideRow<Resource> getMyResource(@RequestParam(defaultValue = "1") Integer page, Integer rows, String name, String type){
		logger.info(page+","+rows+","+name+","+type);
		return new DataGrideRow<Resource>(resourceService.countMyResource(name, type), resourceService.getMyResource(page, rows, type, name));
	}
	
	/**
	 * 删除某个资源
	 * @param id 资源id
	 * @return
	 */
	@RequestMapping(value="deleteResource",method=RequestMethod.POST)
	@ResponseBody
	public BaseMsg deleteResource(String id){
		logger.info("删除资源,id:"+id);
		resourceService.deleteResource(id);
		return new BaseMsg(true, "资源删除成功");
	}
	
	/**
	 * 获取符合条件的learn资源
	 * @param page
	 * @param rows
	 * @param name
	 * @return
	 */
	@RequestMapping(value="getAllStudy",method=RequestMethod.GET)
	@ResponseBody
	public DataGrideRow<Resource> getAllStudy(@RequestParam(defaultValue = "1") Integer page, Integer rows, String name){
		logger.info("访问learn资源");
		logger.info(page+","+ rows +","+ name);
		return new DataGrideRow<Resource>(resourceService.countSum(name, SysConst.LEARN), resourceService.getAllLearn(page,rows,name));
	}
	
	/**
	 * 获取符合条件的Game资源
	 * @param page
	 * @param rows
	 * @param name
	 * @param descirbe
	 * @return
	 */
	@RequestMapping(value="getAllGame",method=RequestMethod.POST)
	@ResponseBody
	public DataGrideRow<Resource> getAllGame(@RequestParam(defaultValue = "1") Integer page,Integer rows, String name, String descirbe){
		logger.info("访问game资源");
		logger.info(page+","+ rows +","+ name + "," + descirbe);
		return new DataGrideRow<Resource>(resourceService.countSum(name, SysConst.GAME), resourceService.getAllGame(page,rows,name,descirbe));
	}
}
