/**
 * 
 */
package com.skit.compare;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.pojo.Student;

public class InsertMongo {

	public static void main(String[] args) {
		System.out.println("Querying Now:");
		InsertMongo i = new InsertMongo();
		System.out.println(i.insertMongo(500));

	}

	public long insertMongo(int n) {

		ApplicationContext ctx = new GenericXmlApplicationContext("spring-config.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		mongoOperation.dropCollection(Student.class);
		long st = System.currentTimeMillis();


		List<Student> queries = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			Student student = new Student();
			student.setName("hh" + i);
			student.setUsn("1VK06CS0" + i);
			queries.add(student);
		}

		mongoOperation.insertAll(queries);

		long en = System.currentTimeMillis();

		return en - st;

	}

}
