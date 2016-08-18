package com.smates.dbc2.memcache.client;

/** 
*  缓存client 为不同的实现对外提供统一的接口
*/
public interface CacheClient {
	/**
	 * 从namespace中获取指定key的值
	 */
	Object read(String nameSpace, String key);

	/**
	 * 向namespace中指定key的位置写入数据，以及缓存的存放时间
	 */
	void write(String nameSpace, String key, Object value, int cacheTime);

	/**
	 * 清除namespace中指定key的位置的数据，如果key为null，那么清理整个namespace的值
	 */
	void clear(String nameSpace, String key);
}
