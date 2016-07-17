package com.skit.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.skit.pojo.StudentBooks;

public class StudentBookDB {

	public void borrow(StudentBooks sb) {
		MongoOperations mongoOperations = MongoUtil.getMongoOperations();
		mongoOperations.save(sb);
	}

	public void returnBook(StudentBooks sb) {
		MongoOperations mongoOperations = MongoUtil.getMongoOperations();

		Query query = new Query(Criteria.where("usn").is(sb.getUsn()).and("book_id").is(sb.getBook_id()));
		StudentBooks sb2 = mongoOperations.findOne(query, StudentBooks.class);

		mongoOperations.remove(sb2);

	}

	public void renewBook(StudentBooks sb1, StudentBooks sb2) {
		MongoOperations mongoOperations = MongoUtil.getMongoOperations();
		Query query = new Query(Criteria.where("usn").is(sb1.getUsn()).and("book_id").is(sb1.getBook_id()));
		StudentBooks sb3 = mongoOperations.findOne(query, StudentBooks.class);
		mongoOperations.remove(sb3);
		mongoOperations.save(sb2);

	}

	public List<StudentBooks> getAllStudentBooks() {
		MongoOperations mongoOperations = MongoUtil.getMongoOperations();
		return mongoOperations.findAll(StudentBooks.class);
	}

	public List<StudentBooks> getAllStudentBooks(String usn) {
		MongoOperations mongoOperations = MongoUtil.getMongoOperations();
		Query query = new Query(Criteria.where("usn").is(usn));
		List<StudentBooks> studentBooks = mongoOperations.find(query, StudentBooks.class);
		return studentBooks;
	}

	public static void main(String arg[]) {

		StudentBookDB db = new StudentBookDB();

		// StudentBooks sb = new StudentBooks();
		// sb.setBook_id("34213");
		// sb.setUsn("1VK06IS009");
		// sb.setDate_of_borrow(new Date());
		// sb.setDate_of_return(new Date(2016, 3, 25));
		// sb.setStatus("PENDING");
		//
		// db.borrow(sb);
		// System.out.println("DONE");

		List<StudentBooks> sb = db.getAllStudentBooks();
		for (StudentBooks s : sb) {
			System.out.println(s);
		}

	}
}