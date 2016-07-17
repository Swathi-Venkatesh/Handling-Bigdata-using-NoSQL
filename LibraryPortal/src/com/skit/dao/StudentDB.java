package com.skit.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.skit.pojo.Book;
import com.skit.pojo.Student;
import com.skit.pojo.StudentBooks;

public class StudentDB {

	public void create(Student st) {
		MongoOperations mongoOperations = MongoUtil.getMongoOperations();
		mongoOperations.save(st);
	}

	public List<Book> getBooksBorrowed(String usn) {
		MongoOperations mongoOperations = MongoUtil.getMongoOperations();
		Query query = new Query(Criteria.where("usn").is(usn));
		List<StudentBooks> studentBooks = mongoOperations.find(query, StudentBooks.class);

		List<Book> bookList = new ArrayList<>();
		Iterator<StudentBooks> it = studentBooks.iterator();
		while (it.hasNext()) {
			StudentBooks sb = it.next();
			Query query2 = new Query(Criteria.where("_id").is(sb.getBook_id()));
			Book book = mongoOperations.findOne(query2, Book.class);
			bookList.add(book);
		}
		return bookList;
	}
	
	public Student getStudent(String usn) {
		MongoOperations mongoOperations = MongoUtil.getMongoOperations();
		Query query = new Query(Criteria.where("usn").is(usn));
		return mongoOperations.findOne(query, Student.class);
	}

	public List<Student> getAllStudents() {
		MongoOperations mongoOperations = MongoUtil.getMongoOperations();
		return mongoOperations.findAll(Student.class);
	}

	public static void main(String arg[]) {
		StudentDB db = new StudentDB();

		// Student s1 = new Student();
		// s1.setUsn("1VK06IS025");
		// s1.setName("Pradeep");
		// db.create(s1);
		// System.out.println("Done");

		// List<Student> students = db.getAllStudents();
		// for (Student s : students) {
		// System.out.println(s);
		// }

		List<Book> books = db.getBooksBorrowed("1VK06IS009");
		for (Book b : books) {
			System.out.println(b);
		}

	}

	public void remove(Student s) {
		MongoOperations mongoOperations = MongoUtil.getMongoOperations();
		mongoOperations.remove(s);

	}
}
