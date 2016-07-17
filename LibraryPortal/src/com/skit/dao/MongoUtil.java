package com.skit.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public class MongoUtil {

	public static MongoOperations getMongoOperations() {
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-config.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		return mongoOperation;
	}
	
	
}
