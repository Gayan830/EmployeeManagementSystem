package com.empmanagement.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empmanagement.dao.ApplicationDao;
import com.empmanagement.entity.User;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User(request.getParameter("firstName"), request.getParameter("lastName"),
				request.getParameter("userName"), request.getParameter("password"), request.getParameter("email"),
				request.getParameter("telephone"), request.getParameter("address"), request.getParameter("role"),
				request.getParameter("position"), request.getParameter("department"));
		
		if (ApplicationDao.appDaoInstance.register(user)) {
			System.out.println("employee Registered successfuly");
			request.setAttribute("message", "successfully Registered!");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "couldn't Register");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}

}
