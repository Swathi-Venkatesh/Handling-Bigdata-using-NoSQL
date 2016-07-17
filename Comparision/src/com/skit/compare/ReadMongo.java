package com.skit.compare;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import com.pojo.Student;

public class ReadMongo {

	public long readMongo() {
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-config.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		long startTime = System.currentTimeMillis();
		Query searchStudentQuery = new Query();

		List<Student> studentFind = mongoOperation.find(searchStudentQuery, Student.class);

		long endTime = System.currentTimeMillis();
		return endTime - startTime;

	}

	public static void main(String args[]) {

		System.out.println("Querying Now:");
		ReadMongo r = new ReadMongo();
		System.out.println(r.readMongo());

	}
}
