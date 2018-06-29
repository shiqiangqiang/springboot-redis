package com.sqq.common;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * 
 * @author PC
 *
 */
@Configuration
@EnableCaching
public class RedisConfig {
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}
	
	/*@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory){
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(factory);
		return redisTemplate;
	}*/
	
	/*@Bean
	public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) { 
	    StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(); 
	    stringRedisTemplate.setConnectionFactory(factory); 
	    return stringRedisTemplate; 
	} */
	
	/**
	 * 配置针对User的RedisTemplate实例
	 */
/*	@Bean
	public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory factory){
		RedisTemplate<String, User> template = new RedisTemplate<String, User>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new RedisObjectSerializer());
		return template;
	}*/

}
