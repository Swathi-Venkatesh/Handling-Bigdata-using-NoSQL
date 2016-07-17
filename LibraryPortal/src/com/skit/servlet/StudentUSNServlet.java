package com.skit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skit.dao.StudentBookDB;
import com.skit.dao.StudentDB;
import com.skit.pojo.Book;
import com.skit.pojo.StudentBooks;

public class StudentUSNServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String usn = req.getParameter("usn");
			StudentDB db = new StudentDB();
			List<Book> borrowed = db.getBooksBorrowed(usn);

			StudentBookDB sb = new StudentBookDB();
			List<StudentBooks> borrowedBooks = sb.getAllStudentBooks(usn);
			System.out.println("Borrowed books .. " + borrowedBooks.size());
			for (StudentBooks s : borrowedBooks) {
				System.out.println(s.getBook_id());
				System.out.println(s.getUsn());
			}
			req.setAttribute("borrowedBooks", borrowedBooks);
			System.out.println("Borrowed .. " + borrowed.size());
			for (Book b : borrowed) {
				System.out.println(b.getBook_id());
				System.out.println(b.getBook_title());
				System.out.println(b.getPublisher());
			}
			req.setAttribute("borrowed", borrowed);
			req.setAttribute("student", db.getStudent(usn));
			req.getRequestDispatcher("transaction.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("transaction.jsp?msg=Something went wrong");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String usn = req.getParameter("usn");
			StudentDB db = new StudentDB();
			List<Book> borrowed = db.getBooksBorrowed(usn);

			StudentBookDB sb = new StudentBookDB();
			List<StudentBooks> borrowedBooks = sb.getAllStudentBooks(usn);
			req.setAttribute("borrowedBooks", borrowedBooks);
			req.setAttribute("borrowed", borrowed);
			req.setAttribute("student", db.getStudent(usn));
			req.getRequestDispatcher("transaction.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("transaction.jsp?msg=Something went wrong");
		}
	}

}
