package com.smates.dbc2.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.smates.dbc2.controller.MenuController;

public class MenuTest {
	
	private static MenuController menuController;
	
	public static void Before(){
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mvc.xml");
		menuController = applicationContext.getBean(MenuController.class);
	}

	@Test
	public void testMenuController(){
//		menuController.getAllMenu(1, null, null);
	}
	
}