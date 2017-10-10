package com.ducetech.framework.util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * Ehcache工具类
 *
 * @ClassName: EhCacheUtils
 * @Date 17-10-10 下午3:20
 */
public class EhCacheUtils {
	/**
	 * 获取缓存
	 *
	 * @param cacheName 缓存名称
	 * @return net.sf.ehcache.Cache
	 * @throws
	 * @Title: getCache
	 * @Date: 17-10-10 下午3:21
	 */
	private static Cache getCache(String cacheName) {
		CacheManager cacheManager = CacheManager.getInstance();
		if (null == cacheManager) {
			return null;
		}
		Cache cache = cacheManager.getCache(cacheName);
		if (null == cache) {
			return null;
		}
		return cache;
	}

	/**
	 * 新增缓存记录
	 *
	 * @param cacheName 缓存名称
	 * @param key       键
	 * @param value     值
	 * @return void
	 * @throws
	 * @Title: put
	 * @Date: 17-10-10 下午3:22
	 */
	public static void put(String cacheName, String key, Object value) {
		Cache cache = getCache(cacheName);
		if (null != cache) {
			Element element = new Element(key, value);
			cache.put(element);
		}
	}

	/**
	 * 删除缓存记录
	 *
	 * @param cacheName 缓存名称
	 * @param key       键
	 * @return boolean
	 * @throws
	 * @Title: remove 删除成功：true 删除失败：false
	 * @Date: 17-10-10 下午3:22
	 */
	public static boolean remove(String cacheName, String key) {
		Cache cache = getCache(cacheName);
		if (null == cache) {
			return false;
		}
		return cache.remove(key);
	}

	/**
	 * 删除全部缓存记录
	 *
	 * @param cacheName 缓存名称
	 * @return void
	 * @throws
	 * @Title: removeAll
	 * @Date: 17-10-10 下午3:24
	 */
	public static void removeAll(String cacheName) {
		Cache cache = getCache(cacheName);
		if (null != cache) {
			cache.removeAll();
		}
	}

	/**
	 * 获取缓存记录
	 *
	 * @param cacheName 缓存名称
	 * @param key       键
	 * @return java.lang.Object 缓存记录,如果缓存或键不存在,返回null
	 * @throws
	 * @Title: get
	 * @Date: 17-10-10 下午3:25
	 */
	public static Object get(String cacheName, String key) {
		Cache cache = getCache(cacheName);
		if (null == cache) {
			return null;
		}
		Element cacheElement = cache.get(key);
		if (null == cacheElement) {
			return null;
		}
		return cacheElement.getObjectValue();
	}
}
