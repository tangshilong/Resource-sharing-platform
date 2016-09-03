package com.smates.dbc2.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.smates.dbc2.controller.VipController;

public class VipResource {
	
	private static VipController vipController;

	@BeforeClass
	@SuppressWarnings("resource")
	public static void Before() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
		vipController = applicationContext.getBean(VipController.class);
	}

	@Test
	public void testGetAllVip() {
		System.out.println(vipController.getAllVip());
	}
	
}
