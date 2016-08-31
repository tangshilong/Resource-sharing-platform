package com.smates.dbc2.memcache.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import com.smates.dbc2.memcache.config.MemcacheConfig;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.MemcachedClientCallable;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.transcoders.SerializingTranscoder;

/**
 * cacheClient的memcached实现
 */
public class MemcacheClient implements CacheClient {

	private MemcachedClient client = null;

	@Override
	public Object read(String nameSpace, final String key) {
		Object data = null;
		try {
			data = client.withNamespace(nameSpace, new MemcachedClientCallable<Object>() {
				public Object call(MemcachedClient memcachedClient)
						throws MemcachedException, InterruptedException, TimeoutException {
					return memcachedClient.get(key);
				}
			});
			client.endWithNamespace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public void clear(String nameSpace, final String key) {
		try {
			if (key == null || key.equals("")) {
				client.invalidateNamespace(nameSpace);
			} else {
				client.withNamespace(nameSpace, new MemcachedClientCallable<Void>() {
					public Void call(MemcachedClient memcachedClient)
							throws MemcachedException, InterruptedException, TimeoutException {
						client.delete(key);
						return null;
					}
				});
				client.endWithNamespace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void write(String nameSpace, final String key, final Object value, final int cacheTime) {
		if (value == null) {
			return;
		}
		try {
			client.withNamespace(nameSpace, new MemcachedClientCallable<Void>() {
				public Void call(MemcachedClient memcachedClient)
						throws MemcachedException, InterruptedException, TimeoutException {
					client.setWithNoReply(key, cacheTime, value);
					return null;
				}
			});
			client.endWithNamespace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init(MemcacheConfig memcachedConfig) {
		List<String> ips = memcachedConfig.getIps();
		List<Integer> ports = memcachedConfig.getPorts();
		List<InetSocketAddress> addresses = new ArrayList<InetSocketAddress>();
		for (int i = 0; i < ips.size(); i++) {
			addresses.add(new InetSocketAddress(ips.get(i), ports.get(i)));
		}
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(addresses);
		try {
			builder.setConnectionPoolSize(memcachedConfig.getConnectionPoolSize());
			builder.setFailureMode(true);
			builder.setTranscoder(new SerializingTranscoder());
			builder.setCommandFactory(new BinaryCommandFactory());
			client = builder.build();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
