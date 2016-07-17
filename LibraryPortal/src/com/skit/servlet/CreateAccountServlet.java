package com.skit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skit.dao.UserDB;
import com.skit.pojo.User;

public class CreateAccountServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			User user = new User();
			user.setEmail(req.getParameter("email"));
			user.setPassword(req.getParameter("pwd"));
			user.setFirstName(req.getParameter("fn"));
			user.setLastName(req.getParameter("ln"));
			UserDB dao = new UserDB();
			dao.register(user);
			resp.sendRedirect("create.jsp?msg=Successfully created an account");
		} catch (Exception e) {
			resp.sendRedirect("create.jsp?msg=Something went wrong.");
		}
	}

}
