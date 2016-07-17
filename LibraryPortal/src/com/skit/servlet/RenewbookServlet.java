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

public class RenewbookServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String usn = req.getParameter("usn");
			String isbn = req.getParameter("isbn");
			StudentBookDB db = new StudentBookDB();
			StudentBooks pojo1 = new StudentBooks();
			pojo1.setUsn(usn);
			pojo1.setBook_id(isbn);

			StudentBooks pojo2 = new StudentBooks();
			pojo2.setUsn(usn);
			pojo2.setBook_id(isbn);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			pojo2.setDate_of_borrow(sdf.parse(req.getParameter("borrowdate")));
			pojo2.setDate_of_return(sdf.parse(req.getParameter("returndate")));
			db.renewBook(pojo1, pojo2);
			resp.sendRedirect("studentusn?usn=" + usn);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("transaction.jsp?msg=Something went wrong");
		}
	}

}
