package com.sqq.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sqq.service.RedisService;

/**
 * Redis 测试用Controller
 * @author PC
 * 测试 -----    -------
 */
@RequestMapping("/redisDemo")
@RestController
public class RedisDemoController {
	@Autowired
	private RedisService redisService;
	
	/**
	 * 写入缓存
	 * @param key
	 * @param value
	 */
	@PostMapping("/setValue2Cache")
	public String setValue2Cache(@RequestParam String key, @RequestParam Object value) {
		redisService.set(key, value);
		return "成功写入！";
	}
	
	/**
	 * 读取缓存
	 * @param key
	 * @return
	 */
	@GetMapping("/getValueFromCache")
	public Object getValueFromCache(String key) {
		return redisService.get(key);
	}
	
	/**
	 * 删除对应的value
	 * @param key
	 */
	@GetMapping("/removeValueByKey")
	public String removeValueByKey(String key) {
		redisService.remove(key);
		return "成功删除！";
	}
	
}
