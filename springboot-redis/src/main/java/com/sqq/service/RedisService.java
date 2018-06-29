package com.sqq.service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
	@Autowired
	private RedisTemplate redisTemplate;
	
	/**
	 * 写入缓存
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean set(final String key, Object value) {
		boolean flag = false;
		try {
			ValueOperations operations = redisTemplate.opsForValue();
			operations.set(key, value);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * 写入缓存设置时效时间
	 * @param key
	 * @param value
	 * @param expireTime
	 * @return
	 */
	public boolean set(final String key, Object value, Long expireTime) {
		boolean flag = false;
		try {
			ValueOperations operations = redisTemplate.opsForValue();
			operations.set(key, value);
			redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * 批量删除对应的value
	 * @param keys
	 */
	public void remove(String... keys) {
		for(String key : keys) {
			remove(key);
		}
	}
	
	/**
	 * 批量删除key
	 * @param pattern
	 */
	public void removePattern(final String pattern) {
		Set<Serializable> keys = redisTemplate.keys(pattern);
		if (keys.size() > 0) {
			redisTemplate.delete(keys);
		}
	}
	
	/**
	 * 判断缓存中是否有对应的value
	 * @param key
	 * @return
	 */
	public boolean exists(final String key) {
		return redisTemplate.hasKey(key);
	}
	
	/**
	 * 删除对应的value
	 * @param key
	 */
	public void remove(final String key){
		if (exists(key)) {
			redisTemplate.delete(key);
		}
	}
	
	/**
     * 读取缓存
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }
	
    /**
     * 哈希 添加
     * @param key
     * @param hashKey
     * @param value
     */
	public void hmSet(String key, Object hashKey, Object value) {
		HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
		hashOperations.put(key, hashKey, value);
	}
	
	/**
	 * 哈希获取数据
	 * @param key
	 * @param hashKey
	 * @return
	 */
	public Object hmGet(String key, Object hashKey) {
		return redisTemplate.opsForHash().get(key, hashKey);
	}
	
	/**
	 * 列表添加
	 * @param key
	 * @param value
	 */
	public void lPush(String key, Object value) {
		ListOperations<String, Object> listOperations = redisTemplate.opsForList();
		listOperations.rightPush(key, value);
	}
	
	/**
	 * 列表获取
	 * @param key
	 * @param l
	 * @param l2
	 * @return
	 */
	public List<Object> lRange(String key, long l, long l2){
		return redisTemplate.opsForList().range(key, l, l2);
	}
	
	/**
	 * 集合添加
	 * @param key
	 * @param value
	 */
	public void add(String key, Object value) {
		SetOperations setOperations =redisTemplate.opsForSet();
		setOperations.add(key, value);
	}
	
	/**
	 * 集合获取
	 * @param key
	 * @return
	 */
	public Set<Object> setMembers(String key){
		SetOperations setOperations =redisTemplate.opsForSet();
		return setOperations.members(key);
	}
	
	/**
	 * 有序结合添加
	 * @param key
	 * @param value
	 * @param score
	 */
	public void zAdd(String key, Object value, double score) {
		ZSetOperations zSetOperations = redisTemplate.opsForZSet();
		zSetOperations.add(key, value, score);
	}
	
	/**
	 * 有序集合获取
	 * @param key
	 * @param score1
	 * @param score2
	 * @return
	 */
	public Set<Object> rangeByScore(String key, double score1, double score2){
		ZSetOperations zSetOperations = redisTemplate.opsForZSet();
		return zSetOperations.rangeByScore(key, score1, score2);
	}
	
}
