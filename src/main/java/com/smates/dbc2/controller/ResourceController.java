package com.smates.dbc2.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.smates.dbc2.po.Resource;
import com.smates.dbc2.po.User;
import com.smates.dbc2.utils.StringUtils;
import com.smates.dbc2.utils.SysConst;
import com.smates.dbc2.vo.BaseMsg;
import com.smates.dbc2.vo.DataGrideRow;

@Controller
public class ResourceController extends BaseController {

	private Logger logger = Logger.getLogger(ResourceController.class);

	/**
	 * 获取符合条件的vip账号资源
	 * 
	 * @param page
	 *            当前页数
	 * @param rows
	 *            每页记录数
	 * @param name
	 *            查询条件,资源名称
	 * @return
	 */
	@RequestMapping(value = "getAllVip", method = RequestMethod.GET)
	@ResponseBody
	public DataGrideRow<Resource> getAllVip(@RequestParam(defaultValue = "1") Integer page, Integer rows, String name) {
		logger.info("访问vip账号资源");
		return new DataGrideRow<Resource>(resourceService.countSum(name, SysConst.VIP),
				resourceService.getAllVip(page, rows, name));
	}

	/**
	 * 获取当前登录用户上传的资源
	 * 
	 * @return
	 */
	@RequestMapping(value = "getMyResource", method = RequestMethod.GET)
	@ResponseBody
	public DataGrideRow<Resource> getMyResource(@RequestParam(defaultValue = "1") Integer page, Integer rows,
			String name, String type) {
		logger.info("获取我的资源");
		return new DataGrideRow<Resource>(resourceService.countMyResource(name, type),
				turnType(resourceService.getMyResource(page, rows, type, name)));
	}

	/**
	 * 改变type返回值，把0,1,2 变成 vip,learn,game
	 * 
	 * @param list
	 * @return
	 */
	private List<Resource> turnType(List<Resource> list) {
		for (int i = 0; i < list.size(); i++) {
			Resource resource = list.get(i);
			switch (resource.getType()) {
			case "0":
				resource.setType("VIP");
				break;
			case "1":
				resource.setType("LEARN");
				break;
			case "2":
				resource.setType("GAME");
				break;
			default:
				break;
			}
		}
		return list;
	}

	/**
	 * 删除某个资源
	 * 
	 * @param id
	 *            资源id
	 * @return
	 */
	@RequestMapping(value = "deleteResource", method = RequestMethod.POST)
	@ResponseBody
	public BaseMsg deleteResource(String id) {
		logger.info("删除资源,id:" + id);
		resourceService.deleteResource(id);
		return new BaseMsg(true, "资源删除成功");
	}

	/**
	 * 获取符合条件的learn资源
	 * 
	 * @param page
	 * @param rows
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "getAllStudy", method = RequestMethod.GET)
	@ResponseBody
	public DataGrideRow<Resource> getAllStudy(@RequestParam(defaultValue = "1") Integer page, Integer rows,
			String name) {
		logger.info("访问learn资源");
		logger.info(page + "," + rows + "," + name);
		return new DataGrideRow<Resource>(resourceService.countSum(name, SysConst.LEARN),
				resourceService.getAllLearn(page, rows, name));
	}

	/**
	 * 获取符合条件的Game资源
	 * 
	 * @param page
	 * @param rows
	 * @param name
	 * @param descirbe
	 * @return
	 */
	@RequestMapping(value = "getAllGame", method = RequestMethod.POST)
	@ResponseBody
	public DataGrideRow<Resource> getAllGame(@RequestParam(defaultValue = "1") Integer page, Integer rows, String name,
			String describe) {
		logger.info("访问game资源");
		logger.info(page + "," + rows + "," + name + "," + describe);
		logger.info(resourceService.countGame(name, describe, SysConst.GAME));
		return new DataGrideRow<Resource>(resourceService.countGame(name, describe, SysConst.GAME),
				resourceService.getAllGame(page, rows, name, describe));
	}

	/**
	 * 根据资源id查找当前用户是否拥有查看权限
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getContentById", method = RequestMethod.POST)
	@ResponseBody
	public BaseMsg getContentById(String id) {
//		logger.info("开始查询权限");
//		String accountNumber = userService.getCurrentUserActNum();
//		logger.info("accountNumber" + "=" + accountNumber);
//		int loginId = resourceService.getIdByAccountNum(accountNumber);
//		logger.info("loginid =" + loginId);
//		String permitAccountNum = resourceService.getPermitAccountNumById(id);
//		logger.info("permitAccountNum" + "=" + permitAccountNum);
//		String[] permitNum = permitAccountNum.split("\\,");
//		for (int i = 0; i < permitNum.length; i++) {
//			logger.info("i" + "=" + i + "," + "permitNumLength" + "=" + permitNum.length);
//			logger.info(permitNum[i]);
//			if (String.valueOf(loginId).equals(permitNum[i])) {
//				return new BaseMsg(true, resourceService.getContentById(id));
//			}
//		}
		/**
		 * 暂时先把选线过滤去掉，后期再加
		 */
		return new BaseMsg(true, resourceService.getContentById(id));
//		logger.info("没查询到当前用户拥有权限");
//		return new BaseMsg(false, "no permit");
	}

	/**
	 * 获取所有用户名称
	 * 
	 * @return
	 */
	@RequestMapping(value="getAllUserName",method=RequestMethod.POST)
	@ResponseBody
	public List<User> getAllUserName(){
		logger.info("获取名称"+userService.getAllUserName());
		return userService.getAllUser();
	}
	
	/**
	 * 用户添加资源
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value="addResource",method=RequestMethod.POST)
	public BaseMsg addResource(String type, String name, String content, String describe, MultipartFile url, String permitAccountNum){
		String resourceUrl = "";
		if (!StringUtils.isEmpty(url.getOriginalFilename())) {
			resourceUrl = StringUtils.formateFileName(url.getOriginalFilename());
			qniuHelper.uploadFile(url, resourceUrl);
		}
		resourceService.addResource(type, name, content, describe,userService.getCurrentUserActNum() , new Date(), resourceUrl, permitAccountNum);
		return new BaseMsg(true, "上传资源成功");
	}
}
