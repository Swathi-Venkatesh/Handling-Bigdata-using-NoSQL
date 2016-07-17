package com.skit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skit.dao.StudentBookDB;
import com.skit.pojo.StudentBooks;

public class ReturnbookServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String usn = req.getParameter("usn");
			String isbn = req.getParameter("isbn");
			StudentBookDB db = new StudentBookDB();
			StudentBooks pojo1 = new StudentBooks();
			pojo1.setUsn(usn);
			pojo1.setBook_id(isbn);

			db.returnBook(pojo1);
			resp.sendRedirect("studentusn?usn=" + usn);

		} catch (Exception e) {
			resp.sendRedirect("transaction.jsp?msg=Something went wrong");
		}
	}

}
