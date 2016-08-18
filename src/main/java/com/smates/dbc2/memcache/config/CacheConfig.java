package com.smates.dbc2.memcache.config;

import com.smates.dbc2.memcache.client.CacheClient;

/**
 * cache config
 */
public interface CacheConfig {
	CacheClient build();
}
