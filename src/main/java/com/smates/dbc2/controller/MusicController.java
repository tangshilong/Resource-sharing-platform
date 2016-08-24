package com.smates.dbc2.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MusicController extends BaseController{
	
	private static Logger logger = Logger.getLogger(UserController.class);

	/**
	 * 通过关键词返回url
	 * @param key
	 * @return
	 */
	@RequestMapping(value = "searchMusic",method=RequestMethod.GET)
	@ResponseBody
	public String searchMusic(String key){
		logger.info("通过关键词查找歌曲");
		String url = "http://so.ard.iyyin.com/s/song_with_out?q="+ key +"&page=1&size=15";
		logger.info(url);
		return url;
	}

}
