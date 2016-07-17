package com.skit.compare;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompareSevlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String n = req.getParameter("n");
			long writemongo = 0;
			long writemysql = 0;
			writemongo = (new InsertMongo()).insertMongo(Integer.parseInt(n));
			writemysql = (new InsertMySQL()).insertMySQL(Integer.parseInt(n));
			long readmysql = (new ReadMySQL()).readMySQL();
			long readmongo = (new ReadMongo()).readMongo();

			System.out.println("mongo read .. "+readmongo);
			System.out.println("mysql read .. "+readmysql);
			req.setAttribute("writemongo", writemongo);
			req.setAttribute("writemysql", writemysql);
			req.setAttribute("readmongo", readmongo);
			req.setAttribute("readmysql", readmysql);
			req.getRequestDispatcher("compare.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("compare.jsp?msg=Something went wrong. ");
		}
	}

}
