package com.smates.dbc2.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用户行为 annotation
 * 
 * @author Administrator
 *
 */
@Target(value = { ElementType.METHOD })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface PersonalLog {
	String value();//用户做了什么
}
