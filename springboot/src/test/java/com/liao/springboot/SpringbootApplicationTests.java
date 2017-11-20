package com.liao.springboot;

import com.liao.dao.UserDAO;
import com.liao.dao.UserMongodbDAO;
import com.liao.framework.mail.MailService;
import com.liao.framework.rabbitmq.HelloSender;
import com.liao.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

//	@Autowired
//	private UserDAO userDAO;
//
//	@Autowired
//	private StringRedisTemplate stringRedisTemplate;
//
//	@Autowired
//	private RedisTemplate redisTemplate;
//
//	@Autowired
//	private HelloSender helloSender;
//
//	@Autowired
//	private MailService mailService;
//
//	@Autowired
//	private UserMongodbDAO userMongodbDAO;


	private MockMvc mockMvc;

	@Before
	public void before() {

	}

	@Test
	public void contextLoads() {
//		userDAO.save(new User(1L, "小明", "123456", "1453@qq.com"));
//		List<User> userList = userDAO.findAll();
//
//		for (User user : userList) {
//			System.out.println(user);
//		}
//		stringRedisTemplate.opsForValue().set("name", "小明");
//		Assert.assertNotNull(stringRedisTemplate.opsForValue().get("name"));
//
//		ValueOperations<String, User> valueOperations = redisTemplate.opsForValue();
//		valueOperations.set("user", new User(1L, "小明", "123456", "124@qq.com"));
//		User user = valueOperations.get("user");
//		System.out.println(user);
//		User user = new User(1L, "小明", "123456", "124@qq.com");
//		helloSender.send(user);

//		mailService.sendMail("hongyangliaogoog@gmail.com", "测试邮件", "这是一封测试邮件");
//		User user = new User(1L, "小明", "123456", "124@qq.com");
//		userMongodbDAO.saveUser(user);
//		List<User> userList = userMongodbDAO.listUserByUserName("小明");
//		for(User _user : userList) {
//			System.out.println(_user);
//		}
//		User updateUser = new User(1L, "小黄", "123456", "421@qq.com");
//		userMongodbDAO.updateUser(updateUser);
//		List<User> updateUserList = userMongodbDAO.listUserByUserName("小明");
//		for(User _user : updateUserList) {
//			System.out.println(_user);
//		}
//
//		//userMongodbDAO.removeUserById(1L);
//
//		List<User> removeUserList = userMongodbDAO.listUserByUserName("小明");
//		for(User _user : removeUserList) {
//			System.out.println(_user);
//		}
	}
}

