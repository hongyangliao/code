package com.liao.dao;

import com.liao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 用户DAO接口
 *
 * @author hongyangliao
 * @ClassName:
 * @Date 17-11-13 下午6:21
 */
public interface UserDAO extends JpaRepository<User, Long> {

	/**
	 * 根据用户名查询用户信息
	 *
	 * @param username
	 * @return com.liao.model.User
	 * @throws
	 * @Title: findUserByUsername
	 * @author: hongyangliao
	 * @Date: 17-11-13 下午6:23
	 */
	User findUserByUsername(String username);

	/**
	 * 查询所有用户信息
	 *
	 * @param
	 * @return java.util.List<com.liao.model.User>
	 * @throws
	 * @Title: findAll
	 * @author: hongyangliao
	 * @Date: 17-11-13 下午6:24
	 */
	List<User> findAll();

}
