package com.smates.dbc2.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.smates.dbc2.qniu.QniuHelper;
import com.smates.dbc2.vo.BaseMsg;


@Controller
public class TestController{
	
	@Autowired
	private QniuHelper qniuHelper;

	public Logger logger = Logger.getLogger(TestController.class);

	@RequestMapping("qniu")
	@ResponseBody
	public BaseMsg addImage(MultipartFile image) throws IOException, ServletException{
//		qniuHelper.uploadFile(image.getBytes(),image.getOriginalFilename());
		
		qniuHelper.deleteFile(image.getOriginalFilename());
		return new BaseMsg(true, "123");
	}

}
