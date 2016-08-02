package com.smates.dbc2.controller;

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
 * @author baijw12
 *
 */
@Controller
public class UserController extends BaseController{
	
	/**
	 * 返回登录界面
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(){
		return "Login.ftl";
	}
	
	/**
	 * 处理登录请求
	 * @param userid 用户登录的userid
	 * @param userpwd 用户登录的明文密码
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String submit(String userid,String userpwd){
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userid, userpwd);
		try{
			subject.login(token);
		}catch(AuthenticationException ae){
			return "Login.ftl";
		}
		return "redirect:home.do";
	}
	
	/**
	 * 登出
	 * @return
	 */
	@RequestMapping("logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "Login.ftl";
    }
	
	/**
	 * 登录成功后,显示主界面,根据用户不同的权限,显示不同的菜单
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("home")
	public String home(ModelMap modelMap){
		modelMap.addAttribute("menulist", menuService.getMenuByRoles());
		return "Home.ftl";
	}
	
	@RequestMapping("test")
	public String test(ModelMap modelMap){
		return "Home.ftl";
	}

}
