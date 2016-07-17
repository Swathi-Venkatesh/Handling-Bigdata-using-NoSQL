package com.skit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skit.dao.UserDB;
import com.skit.pojo.User;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String email = req.getParameter("email");
			String password = req.getParameter("pwd");
			UserDB dao = new UserDB();
			User u = dao.login(email, password);
			if (u != null) {
				req.getSession().setAttribute("user", u);
				resp.sendRedirect("home.jsp?msg=Login Successful");
			} else {
				resp.sendRedirect("login.jsp?msg=Invalid Credentials");

			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("login.jsp?msg=Something went wrong");
		}
	}

}