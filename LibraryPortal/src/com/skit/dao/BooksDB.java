package com.skit.dao;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.skit.pojo.Book;

public class BooksDB {

	public void create(Book b) {
		MongoOperations mongoOperations = MongoUtil.getMongoOperations();
		mongoOperations.save(b);
	}

	public List<Book> getAllBooks() {
		MongoOperations mongoOperations = MongoUtil.getMongoOperations();

		return mongoOperations.findAll(Book.class);
	}

	public static void main(String arg[]) {
		BooksDB db = new BooksDB();
		//
		// Book b1 = new Book();
		// b1.setBook_author("AM Padmareddy");
		// b1.setBook_id("43421");
		// b1.setBook_title("C++");
		// b1.setPublisher("Nandi");
		// b1.setQuantity(5);
		// db.create(b1);
		// System.out.println("DONE");

		List<Book> books = db.getAllBooks();
		for (Book b : books) {
			System.out.println(b);
		}

		MongoOperations mongoOperations = MongoUtil.getMongoOperations();
		Query query2 = new Query(Criteria.where("book_id").is("12345"));
		Book book = mongoOperations.findOne(query2, Book.class);

		System.out.println(book);
	}

	public void remove(Book b) {
		MongoOperations mongoOperations = MongoUtil.getMongoOperations();
		mongoOperations.remove(b);
		
	}
}
