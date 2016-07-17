package com.skit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skit.dao.StudentDB;
import com.skit.pojo.Student;

public class GetAllStudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			StudentDB db = new StudentDB();
			List<Student> students = db.getAllStudents();
			req.setAttribute("students", students);
			req.getRequestDispatcher("students.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("students.jsp?msg=Something went wrong while reading the data");
		}

	}
}
