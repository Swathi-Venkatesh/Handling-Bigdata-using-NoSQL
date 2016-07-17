package com.skit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skit.dao.BooksDB;
import com.skit.dao.StudentDB;
import com.skit.pojo.Book;
import com.skit.pojo.Student;

public class WriteBookServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			Book b = new Book();
			b.setBook_author(req.getParameter("author"));
			b.setBook_id(req.getParameter("id"));
			b.setBook_title(req.getParameter("title"));
			b.setPublisher(req.getParameter("publisher"));
			// b.setQuantity(Integer.parseInt(req.getParameter("qty")));

			BooksDB db = new BooksDB();
			db.create(b);

			List<Book> books = db.getAllBooks();
			req.setAttribute("books", books);
			req.getRequestDispatcher("books.jsp?msg=Successfully added a book").forward(req, resp);
		} catch (Exception e) {
			try {
				e.printStackTrace();
				BooksDB db = new BooksDB();
				List<Book> books = db.getAllBooks();
				req.setAttribute("books", books);
				req.getRequestDispatcher("books.jsp?msg=Something went wrong while writing a book").forward(req, resp);
			} catch (Exception e2) {
				resp.sendRedirect("books.jsp?msg=Something went wrong. Please try again.");

			}
		}

	}
}
