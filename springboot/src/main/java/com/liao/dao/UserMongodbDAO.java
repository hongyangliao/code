package com.liao.dao;


import com.liao.model.User;

import java.util.List;

/**
 * 用户Mongodb DAO接口
 *
 * @author hongyangliao
 * @ClassName:
 * @Date 17-11-20 下午2:24
 */
public interface UserMongodbDAO {

	void saveUser(User user);

	void removeUserById(Long id);

	void updateUser(User user);

	List<User> listUserByUserName(String username);
}
