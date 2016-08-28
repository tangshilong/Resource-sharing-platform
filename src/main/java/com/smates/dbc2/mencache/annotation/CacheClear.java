package com.smates.dbc2.mencache.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 缓存清理annotation 包括定义namespace 与 默认key
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheClear {
	
	String cachePrefix() default "";

	String defaultKey() default "";

	String nameSpace();

}
