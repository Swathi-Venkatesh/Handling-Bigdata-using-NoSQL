package com.skit.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skit.dao.StudentBookDB;
import com.skit.pojo.StudentBooks;

public class BorrowServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String usn = req.getParameter("usn");
			String isbn = req.getParameter("isbn");

			StudentBooks sb = new StudentBooks();
			sb.setUsn(usn);
			sb.setBook_id(isbn);
			sb.setDate_of_borrow(new Date(System.currentTimeMillis()));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			sb.setDate_of_return(sdf.parse(req.getParameter("return")));
			StudentBookDB sbdb = new StudentBookDB();
			sbdb.borrow(sb);

			resp.sendRedirect("studentusn?usn=" + usn);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("transaction.jsp?msg=Something went wrong");
		}

	}

}
