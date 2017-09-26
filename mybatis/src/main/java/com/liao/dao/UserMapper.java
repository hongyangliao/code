package com.liao.dao;

import com.liao.model.User;

/**
 * user数据操作类
 */
public interface UserMapper {
	/**
	 * 根据id获取user
	 * @param id
	 * @return
	 */
	User getUserById(Integer id);
}
