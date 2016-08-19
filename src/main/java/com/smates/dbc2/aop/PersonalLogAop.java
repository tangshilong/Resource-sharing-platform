package com.smates.dbc2.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.smates.dbc2.memcache.CacheManager;


/**
 * 
 * 用户行为记录，对于标记了annotation标注的地方，获取标注的值作为用户行为，以及方法参数列作为用户行为参数存入数据库
 */

@Aspect
@Component
public class PersonalLogAop {

	private static Logger logger = Logger.getLogger(CacheManager.class);

	
	@Pointcut("@annotation(com.smates.dbc2.aop.PersonalLog)")
	public void record() {
	}
	
	@After("record()")
	public void doAfter(JoinPoint joinPoint) {
		logger.info("用户行为日志成功");
	}

	

}
