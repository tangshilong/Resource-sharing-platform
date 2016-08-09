package com.smates.dbc2.controller;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户相关的请求
 * @author tangShilong
 *
 */
@Controller
public class UserController extends BaseController{
	private static Logger logger = Logger.getLogger(UserController.class);

	
	/**
	 * 返回登录界面
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(){
		return "Login.ftl";
	}
	
	/**
	 * TODO 处理登录请求
	 * @param userid 用户登录的accountNumber
	 * @param userpwd 用户登录的明文密码
	 * @return
	 * TODO tangShilong 未完成
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String submit(String accountNumber,String userpwd){
		Subject subject = SecurityUtils.getSubject();
		logger.info(accountNumber+ "," + userpwd);
		UsernamePasswordToken token = new UsernamePasswordToken(accountNumber, userpwd);
		try{
			subject.login(token);
		}catch(AuthenticationException ae){
			logger.info("密码错误");
			return "Login.ftl";
		}
		logger.info("test2");
		return "redirect:home.do";
	}
	
	/**
	 * TODO 登出
	 * @return
	 * TODO tangShilong 未完成
	 */
	@RequestMapping("logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "Login.ftl";
    }
	
	/**
	 * TODO 登录成功后,显示主界面,根据用户不同的权限,显示不同的菜单
	 * @param modelMap
	 * @return
	 * TODO tangShilong 未完成
	 */
	@RequestMapping("home")
	public String home(ModelMap modelMap){
		logger.info(menuService.getMenuByRoles().size());
		modelMap.addAttribute("menulist", menuService.getMenuByRoles());
		modelMap.addAttribute("userName", userService.getUserByAccountNumber(userService.getCurrentUserId()).getNickName());
		return "Home.ftl";
	}
	
	@RequestMapping("test")
	public String test(ModelMap modelMap){
		return "Home.ftl";
	}

	
	
}
