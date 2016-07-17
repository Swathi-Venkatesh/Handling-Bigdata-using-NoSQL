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

public class RemoveBookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Book b = new Book();
			b.setBook_id(req.getParameter("id"));
			BooksDB db = new BooksDB();
			db.remove(b);
			List<Book> books = db.getAllBooks();
			req.setAttribute("books", books);
			req.getRequestDispatcher("books.jsp?msg=Successfully deleted the books entry").forward(req, resp);
		} catch (Exception e) {
			try {
				e.printStackTrace();
				StudentDB db = new StudentDB();
				List<Student> students = db.getAllStudents();
				req.setAttribute("books", students);
				req.getRequestDispatcher("books.jsp?msg=Something went wrong while booking the Inventory entry")
						.forward(req, resp);
			} catch (Exception e2) {
				resp.sendRedirect("books.jsp?msg=Something went wrong. Please try again.");
			}
		}

	}

}
