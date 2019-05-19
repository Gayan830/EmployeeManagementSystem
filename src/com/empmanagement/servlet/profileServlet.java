package com.empmanagement.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empmanagement.dao.ApplicationDao;
import com.empmanagement.entity.User;

@WebServlet("/profileServlet")
public class profileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/manage-profile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String confirmPassword = request.getParameter("confirmPassword");
		String telephone = request.getParameter("telephone");
		String address = request.getParameter("address");
		User user = (User) request.getSession().getAttribute("user");
		
		if(confirmPassword.equals(password)) {
		ApplicationDao.getInstance().updateEmployeeDetails(new User(user.getEmployeeId(),firstName,
							lastName,userName,password,email,telephone,address,user.getRole(),
							user.getDepartment()));
		
		} else {
			request.setAttribute("error", "password field not matched to confirm password field");
			
		}
		
		request.getRequestDispatcher("/manage-profile.jsp").forward(request, response);	
				
	}

}
