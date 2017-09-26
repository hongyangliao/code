package com.liao.test;

import com.liao.dao.UserMapper;
import com.liao.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * 测试类
 */
public class Test {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("configuration.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (reader != null) {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}
	}

	/**
	 * 获取sqlSerssionFactory
	 * @return
	 */
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = null;

		if(sqlSessionFactory != null) {
			sqlSession = sqlSessionFactory.openSession();
		}

		if(sqlSession != null) {
			//User user = sqlSession.selectOne("com.liao.dao.UserMapper.getUserById",1);
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = userMapper.getUserById(1);
			System.out.println(user.getUserName());
			sqlSession.close();
		}
	}
}