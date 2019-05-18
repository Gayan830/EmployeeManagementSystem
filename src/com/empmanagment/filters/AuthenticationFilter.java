package com.empmanagment.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class AuthenticationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		if(request.getRequestURI().startsWith("/Employee_Management_System/example.jsp") ||
				request.getRequestURI().startsWith("/Employee_Management_System/ListEmployees")||
				request.getRequestURI().startsWith("/Employee_Management_System/profileServlet") ||
				request.getRequestURI().startsWith("/Employee_Management_System/PromotionRequestServlet")||
				request.getRequestURI().startsWith("/Employee_Management_System/NotificationServlet") ||
				request.getRequestURI().startsWith("/Employee_Management_System/SalaryReportServlet")) {
			HttpSession session = request.getSession();
			if(session.getAttribute("user") == null) {
				request.getRequestDispatcher("/login.jsp").forward(request, arg1);
			}
		}
			
		arg2.doFilter(request, arg1);
	}
	
	

}
