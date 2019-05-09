package com.empmanagement.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//controls manager-header
@WebServlet("/ManagerServlet")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String theCommand = request.getParameter("command");
		if(theCommand == null) {
			theCommand = "LoadDashBoard";
		}
		
		switch(theCommand) {
			case "LoadHomePage":
				loadHomePage(request,response);
				break;
			case "LoadDashBoard":
				loadDashBoard(request,response);
				break;
			case "Profile":
				loadProfile(request,response);
				break;
			case "Logout":
				loadLogout(request,response);
				break;
			default:
				loadHomePage(request,response);
				break;
				
		}
	}
	
	
private void loadLogout(HttpServletRequest request, HttpServletResponse response) {
		
	}



private void loadProfile(HttpServletRequest request, HttpServletResponse response) {

		
	}




	private void loadHomePage(HttpServletRequest request, HttpServletResponse response) {
		
	}



	private void loadDashBoard(HttpServletRequest request, HttpServletResponse response) {

		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
