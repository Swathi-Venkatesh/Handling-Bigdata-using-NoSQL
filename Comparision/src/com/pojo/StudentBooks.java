package com.pojo;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student_books")
public class StudentBooks {

	@Id
	private BigInteger id;
	private String usn;
	private String book_id;
	private Date date_of_borrow;

	@Override
	public String toString() {
		return "StudentBooks [usn=" + usn + ", book_id=" + book_id + ", date_of_borrow=" + date_of_borrow
				+ ", date_of_return=" + date_of_return + "]";
	}

	public String getUsn() {
		return usn;
	}

	public void setUsn(String usn) {
		this.usn = usn;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public Date getDate_of_borrow() {
		return date_of_borrow;
	}

	public void setDate_of_borrow(Date date_of_borrow) {
		this.date_of_borrow = date_of_borrow;
	}

	public Date getDate_of_return() {
		return date_of_return;
	}

	public void setDate_of_return(Date date_of_return) {
		this.date_of_return = date_of_return;
	}

	private Date date_of_return;

}
