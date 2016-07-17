package com.skit.dao;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.skit.pojo.User;

public class UserDB {

	public void register(User user) {
		MongoOperations mongoOperations = MongoUtil.getMongoOperations();
		mongoOperations.save(user);
	}

	public User login(String email, String password) {
		MongoOperations mongoOperations = MongoUtil.getMongoOperations();
		Query query = new Query(Criteria.where("email").is(email));
		User u = mongoOperations.findOne(query, User.class);
		System.out.println("email .. "+u.getEmail());
		System.out.println("pwd .. "+u.getPassword());
		System.out.println("fn .. "+u.getFirstName());
		System.out.println("ln .. "+u.getLastName());
		if (u.getPassword().equals(password)) {
			return u;
		} else
			return null;
	}

}
