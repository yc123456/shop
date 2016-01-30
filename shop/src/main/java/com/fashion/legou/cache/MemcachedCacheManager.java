package com.fashion.legou.cache;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.transaction.AbstractTransactionSupportingCacheManager;

import net.rubyeye.xmemcached.MemcachedClient;

public class MemcachedCacheManager extends AbstractTransactionSupportingCacheManager implements CacheManager {
	private ConcurrentMap<String, Cache> cacheMap = new ConcurrentHashMap<String, Cache>();
	private Map<String, Integer> expireMap = new HashMap<String, Integer>();//存储缓存失效时间
	private MemcachedClient memcachedClient;

	public MemcachedCacheManager() {
	}

	@Override
	public Cache getCache(String name) {
		Cache cache = cacheMap.get(name);
		if (cache == null) {
			Integer expire = expireMap.get(name);
			if (expire == null) {
				expire = 60;
				expireMap.put(name, expire);
			}
			cache = new MemcachedCache(name, expire.intValue(), memcachedClient);
			cacheMap.put(name, cache);
		}
		return cache;
	}

	@Override
	public Collection<String> getCacheNames() {

		return null;
	}

	@Override
	protected Collection<? extends Cache> loadCaches() {
		Collection<Cache> values = cacheMap.values();
		return values;
	}

	public void setMemcachedClient(MemcachedClient memcachedClient) {
		this.memcachedClient = memcachedClient;
	}

	public void setConfigMap(Map<String, Integer> configMap) {
		this.expireMap = configMap;
	}

}
