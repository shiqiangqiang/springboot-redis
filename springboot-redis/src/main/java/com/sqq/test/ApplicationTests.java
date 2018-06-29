//package com.sqq.test;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.mock.web.MockServletContext;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import com.sqq.StartUpApplication;
//import com.sqq.domain.User;
//
///**
// * 测试用例，访问Redis
// * @author PC
// *
// */
//@RunWith(SpringJUnit4ClassRunner.class)   // SpringJUnit支持，由此引入Spring-Test框架支持
//@SpringBootTest(classes=StartUpApplication.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)  // 如果你需要启动一个full running server，推荐使用random ports
//@WebAppConfiguration	
//public class ApplicationTests {
//	@Autowired
//	private StringRedisTemplate stringRedisTemplate;
//	
//	@Autowired
//	private RedisTemplate<String, User> redisTemplate;
//	
//	@Test
//	public void test() throws Exception{
//		// 保存字符串
//		stringRedisTemplate.opsForValue().set("aaa", "111");
//		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
//	}
//	
//	/**
//	 * 测试保存对象
//	 * @throws Exception
//	 */
//	@Test
//	public void testSaveObject() throws Exception{
//		User user = new User("超人", 20);
//		redisTemplate.opsForValue().set(user.getUserName(), user);
//		
//		user = new User("张三", 24);
//		redisTemplate.opsForValue().set(user.getUserName(), user);
//		
//		user = new User("李四", 26);
//		redisTemplate.opsForValue().set(user.getUserName(), user);
//		
//		Assert.assertEquals(20, redisTemplate.opsForValue().get("超人"));
//		Assert.assertEquals(24, redisTemplate.opsForValue().get("张三"));
//		Assert.assertEquals(26, redisTemplate.opsForValue().get("李四"));
//	}
//	
//}
