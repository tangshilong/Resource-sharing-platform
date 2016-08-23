package com.smates.dbc2.mencache.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 缓存read的标注，包括缓存的namespace，默认key，缓存时间（秒）
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheRead {
	
	String cachePrefix() default "";

	String defaultKey() default "data";

	String nameSpace();

	int cacheTime() default 24 * 60 * 60; //second

}
