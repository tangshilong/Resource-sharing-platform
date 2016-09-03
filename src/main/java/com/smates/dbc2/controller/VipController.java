package com.smates.dbc2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smates.dbc2.po.Vip;

@Controller
public class VipController extends BaseController{
	
	@RequestMapping(value="getAllVip",method=RequestMethod.GET)
	@ResponseBody
	public List<Vip> getAllVip(){
		return vipServiceImpl.getAllVip();
	}
	
}
