package com.smates.dbc2.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Login {
	
	@RequestMapping("login")
	public String login(){
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
