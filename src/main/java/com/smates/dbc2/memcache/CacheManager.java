package com.smates.dbc2.memcache;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smates.dbc2.memcache.client.CacheClient;
import com.smates.dbc2.memcache.config.CacheConfig;
import com.smates.dbc2.mencache.annotation.CacheClear;
import com.smates.dbc2.mencache.annotation.CacheKey;
import com.smates.dbc2.mencache.annotation.CacheKeyInfo;
import com.smates.dbc2.mencache.annotation.CacheRead;

/** 
*  缓存管理的配置类
*  可在spring中配置如: 
*  <bean class="com.xiechanglei.code.spring.cache.CacheManager" init-method="init">
*      		<property name="cacheConfig" ref="memcachedConfig"></property>
*       </bean>
*   
*       ps:cacheConfig 是你的缓存配置类,see {@link com.smates.dbc2.memcache.client.CacheClient}
*       	不同的缓存插件使用不同的实现
*   
*   实现逻辑:
*   	在标注了CacheRead方法执行前，根据方法的的参数生成字符串key {@link CacheManager#buildKey(Method, Object[])},
*   	然后根据此key以及一些其他参数从缓存插件中读取缓存值
*   	如果缓存存在，那么将不执行此方法，直接将缓存值返回
*   	如果缓存不存在，那么执行方法，并且在执行后将缓存的值放入缓存插件中
*   
*/
@Aspect
@Component
public class CacheManager {
	public static Logger logger = Logger.getLogger(CacheManager.class);
	@Autowired
	private CacheConfig cacheConfig;

	private CacheClient cacheClient;

	public CacheConfig getCacheConfig() {
		return cacheConfig;
	}

	public void setCacheConfig(CacheConfig cacheConfig) {
		this.cacheConfig = cacheConfig;
	}
	/** 
	 * 根据cacheconfig 创建cacheClient的实现
	*/
	public void init() {
		if (cacheConfig != null) {
			logger.info("cache is enable");
			cacheClient = cacheConfig.build();
		} else {
			logger.info("cache is disable");
		}
	}

	@Pointcut("@annotation(com.smates.dbc2.mencache.annotation.CacheRead)")
	public void cacheRead() {
	}

	@Pointcut("@annotation(com.smates.dbc2.mencache.annotation.CacheClear)")
	public void cacheClear() {
	}

	/** 
	 * cache read around 执行,查询缓存，判断是否执行方法,以及执行方法之后放入缓存
	*/
	@Around("cacheRead()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		try {
			Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
			CacheRead cacheRead = method.getAnnotation(CacheRead.class);
			String key = buildKey(cacheRead.cachePrefix(), method, joinPoint.getArgs());
			key = (key == null ? cacheRead.defaultKey() : key);
			Object data = cacheClient.read(cacheRead.nameSpace(), key);
			if (data == null) {
				Object proceed = joinPoint.proceed();
				cacheClient.write(cacheRead.nameSpace(), key, proceed, cacheRead.cacheTime());
				return proceed;
			} else {
				logger.info("read data from cache with namespace:" + cacheRead.nameSpace() + " key:" + key);
				return data;
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * cache clear after 执行,清理缓存
	 */
	@After("cacheClear()")
	public void doAfterUpdateData(JoinPoint joinPoint) {
		try {
			Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
			CacheClear cacheClear = method.getAnnotation(CacheClear.class);
			String key = buildKey(cacheClear.cachePrefix(), method, joinPoint.getArgs());
			key = (key == null ? cacheClear.defaultKey() : key);
			cacheClient.clear(cacheClear.nameSpace(), key);
			logger.info("clear cache  with namespace:" + cacheClear.nameSpace() + " key:" + key);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 
	 * 根据method生成key
	*/
	private String buildKey(String prefix, Method method, Object[] args) {
		List<CacheKeyInfo> keys = getMethodParamKeys(method, args);
		String key = buildKeyByMethodParam(method, keys);
		if (key == null) {
			return null;
		} else {
			return prefix + key;
		}
	}
	
	/**
	 * 生成key的规则，value按顺序用“-”隔开
	 */
	private String buildKeyByMethodParam(Method method, List<CacheKeyInfo> keys) {
		if (keys.size() > 0) {
			Collections.sort(keys);
			String key_str = "";
			for (int i = 0; i < keys.size(); i++) {
				key_str += "_" + keys.get(i).getValue().toString();
			}
			return key_str;
		} else {
			return null;
		}
	}
	
	/**
	 * 根据方法获得所有的keyinfo，包括值value与key顺序index
	 */
	private List<CacheKeyInfo> getMethodParamKeys(Method method, Object[] args) {
		List<CacheKeyInfo> keys = new ArrayList<CacheKeyInfo>();
		Annotation[][] parameterAnnotations = method.getParameterAnnotations();
		loop: for (int i = 0; i < parameterAnnotations.length; i++) {
			for (int j = 0; j < parameterAnnotations[i].length; j++) {
				Annotation annotation = parameterAnnotations[i][j];
				if (annotation instanceof CacheKey) {
					if(args[i] == null){
						keys.add(new CacheKeyInfo("null", ((CacheKey) annotation).value()));
					}else{
						keys.add(new CacheKeyInfo(args[i].toString(), ((CacheKey) annotation).value()));
					}
					continue loop;
				}
			}
		}
		return keys;
	}
}
