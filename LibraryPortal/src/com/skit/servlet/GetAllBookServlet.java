package com.skit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skit.dao.BooksDB;
import com.skit.pojo.Book;

public class GetAllBookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			BooksDB db = new BooksDB();
			List<Book> books = db.getAllBooks();
			req.setAttribute("books", books);
			req.getRequestDispatcher("books.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("books.jsp?msg=Something went wrong while reading the data");
		}

	}
}
