package com.smates.dbc2.memcache.config;

import java.util.List;

import com.smates.dbc2.memcache.client.CacheClient;
import com.smates.dbc2.memcache.client.MemcacheClient;

/**
 * memcached config
 */
public class MemcacheConfig  implements CacheConfig{
	
	public static final int DEFAUT_CONNECTION_POOL_SIZE = 10;
	private List<String> ips;
	private List<Integer> ports;
	private Integer connectionPoolSize;
	
	public Integer getConnectionPoolSize() {
		return connectionPoolSize;
	}
	public void setConnectionPoolSize(Integer connectionPoolSize) {
		this.connectionPoolSize = connectionPoolSize;
	}
	public List<String> getIps() {
		return ips;
	}
	public void setIps(List<String> ips) {
		this.ips = ips;
	}
	public List<Integer> getPorts() {
		return ports;
	}
	public void setPorts(List<Integer> ports) {
		this.ports = ports;
	}
	@Override
	public CacheClient build() {
		MemcacheClient client = new MemcacheClient();
		if(this.connectionPoolSize==null){
			this.connectionPoolSize = DEFAUT_CONNECTION_POOL_SIZE;
		}
		client.init(this);
		return client;
	}
	
	
	
}
