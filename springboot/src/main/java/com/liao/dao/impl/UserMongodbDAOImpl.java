package com.liao.dao.impl;

import com.liao.dao.UserMongodbDAO;
import com.liao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户Mongodb DAO实现类
 *
 * @author hongyangliao
 * @ClassName:
 * @Date 17-11-20 下午2:37
 */
@Repository
public class UserMongodbDAOImpl implements UserMongodbDAO {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void saveUser(User user) {
		mongoTemplate.insert(user);
	}

	@Override
	public void removeUserById(Long id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		mongoTemplate.remove(query,User.class);
	}

	@Override
	public void updateUser(User user) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(user.getId()));
		Update update = new Update();
		update.set("username",user.getUsername()).set("email",user.getEmail());
		mongoTemplate.updateFirst(query,update,User.class);
	}

	@Override
	public List<User> listUserByUserName(String username) {
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(username));
		return mongoTemplate.find(query,User.class);
	}
}
