package com.liao.controller;

import com.liao.dao.UserDAO;
import com.liao.dao.UserMapper;
import com.liao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;


/**
 * HelloController
 *
 * @ClassName: HelloController
 * @Date 17-11-13 下午1:58
 */
@RestController
public class HelloController {

	@Autowired
	private UserDAO userDAO;

//	@Autowired
//	private UserMapper userMapper;

	//获取配置文件中的配置
	@Value("${username}")
	private String username;

	@Value("${password}")
	private String password;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "hello world";
	}

	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String userInfo() {
		return "username:" + username + ",password:" + password;
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	@Cacheable(value = "user")
	public User getUser() {
		User user = userDAO.findUserByUsername("小明");
		return user;
	}

	@RequestMapping(value = "/uid")
	public String uid(HttpSession session) {
		String uid = (String) session.getAttribute("uid");
		if (uid != null) {
			return uid;
		}
		uid = UUID.randomUUID().toString();
		session.setAttribute("uid", uid);
		return (String) session.getAttribute("uid");
	}

//	@RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
//	public List<User> getAllUser() {
//		return userMapper.listUser();
//	}
//
//	@RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
//	public User getUser(@PathVariable(value = "id") Long id) {
//		System.out.println("id:" + id);
//		return userMapper.getUserById(id);
//	}
}
