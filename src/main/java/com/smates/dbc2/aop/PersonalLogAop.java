package com.smates.dbc2.aop;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smates.dbc2.po.UserLog;
import com.smates.dbc2.service.UserLogService;
import com.smates.dbc2.service.UserService;

/**
 * 
 * 用户行为记录，对于标记了annotation标注的地方，获取标注的值作为用户行为，以及方法参数列作为用户行为参数存入数据库
 */

@Aspect
@Component
public class PersonalLogAop {
	
	@Autowired
	private UserLogService userLogService;
	
	@Autowired
	private UserService userService;

	private static Logger logger = Logger.getLogger(PersonalLogAop.class);

	@After(value = "@annotation(com.smates.dbc2.aop.PersonalLog)")
	public void doAfter(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String[] parameterNames = signature.getParameterNames();
		Method method = signature.getMethod();
		PersonalLog personalLog = method.getAnnotation(PersonalLog.class);
		Object[] args = joinPoint.getArgs();
		Map<String, String> paraMap = buildParamMap(parameterNames, args);
		userLogService.addUserLog(new UserLog(personalLog.value(), userService.getCurrentUserId(), paraMap, new Date()));
		logger.info("用户行为日志成功");
	}

	//用户行为参数,即方法参数和值
	private Map<String, String> buildParamMap(String[] parameters, Object[] args) {
		HashMap<String, String> params = new HashMap<String, String>();
		if (parameters != null) {
			for (int i = 0; i < parameters.length; i++) {
				if (args[i] == null) {
					args[i] = "null";
				}
				params.put(parameters[i], args[i].toString());
			}
		}
		return params;
	}

}
