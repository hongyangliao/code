package com.liao.dao;

import com.liao.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户映射接口
 *
 * @author hongyangliao
 * @ClassName: UserMapper
 * @Date 17-11-14 下午4:21
 */
public interface UserMapper {
	@Select("select * from user")
	@Results(id = "userMap", value = {
			@Result(property = "id", column = "id", javaType = java.lang.Long.class),
			@Result(property = "username", column = "username", javaType = java.lang.String.class),
			@Result(property = "password", column = "password", javaType = java.lang.String.class),
			@Result(property = "email", column = "email", javaType = java.lang.String.class)
	})
	List<User> listUser();

	@Select("select * from user where id = #{id}")
	@ResultMap(value = "userMap")
	User getUserById(@Param(value = "id") Long id);
}
