package com.smates.dbc2.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.smates.dbc2.controller.ResourceController;

public class VipResource {
	
	private static ResourceController vipController;

	@BeforeClass
	@SuppressWarnings("resource")
	public static void Before() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
		vipController = applicationContext.getBean(ResourceController.class);
	}

	@Test
	public void testGetAllVip() {
		System.out.println(vipController.getAllVip(1, 10, null));
	}
	
}
