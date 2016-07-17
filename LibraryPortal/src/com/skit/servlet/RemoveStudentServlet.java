package com.skit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skit.dao.StudentDB;
import com.skit.pojo.Student;

public class RemoveStudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Student s = new Student();
			s.setUsn(req.getParameter("usn"));
			StudentDB db = new StudentDB();
			db.remove(s);
			List<Student> students = db.getAllStudents();
			req.setAttribute("students", students);
			req.getRequestDispatcher("students.jsp?msg=Successfully deleted the student entry").forward(req, resp);
		} catch (Exception e) {
			try {
				e.printStackTrace();
				StudentDB db = new StudentDB();
				List<Student> students = db.getAllStudents();
				req.setAttribute("students", students);
				req.getRequestDispatcher("students.jsp?msg=Something went wrong while deleting the student entry")
						.forward(req, resp);
			} catch (Exception e2) {
				resp.sendRedirect("students.jsp?msg=Something went wrong. Please try again.");
			}
		}

	}

}
