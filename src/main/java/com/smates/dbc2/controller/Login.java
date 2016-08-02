package com.smates.dbc2.controller;

import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smates.dbc2.dao.UserAdviceDao;
import com.smates.dbc2.po.UserAdvice;
import com.smates.dbc2.service.UserService;

@Controller
public class Login {
	
	@Autowired
	private UserAdviceDao userAdviceDao;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("login")
	public String login(){
		userAdviceDao.insert(new UserAdvice("111", 111, 1111, null, new Date()));
		userService.getUserById("admin");userService.getUserById("admin");
		return "Login.ftl";
	}
	
	@RequestMapping("submit")
	public String submit(String userid,String userpwd,ModelMap modelMap){
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userid, userpwd);
		try{
			subject.login(token);
		}catch(AuthenticationException ae){
			modelMap.addAttribute("reply", "-1");
			return "Login.ftl";
		}
		return "Home.ftl";
	}
	
	@RequestMapping("logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "Login.ftl";
    }

}
