package com.empmanagement.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.empmanagement.dao.ApplicationDao;
import com.empmanagement.entity.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("userName");
		String password = request.getParameter("password");
		User user = ApplicationDao.getInstance().isValidUser(email, password);
		if (user != null) {

			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			if (user.getRegistered().toLowerCase().equals("yes")) {
				request.getRequestDispatcher("example.jsp").forward(request, response);
			} else {
				String errorMessage = "You are registration request pending.";
				request.setAttribute("error", errorMessage);
				request.getRequestDispatcher("login.jsp").forward(request, response);

			}
		} else {
			String errorMessage = "Invalid Credentials, please login again!";
			request.setAttribute("error", errorMessage);
			request.getRequestDispatcher("login.jsp").forward(request, response);

		}
	}

}
