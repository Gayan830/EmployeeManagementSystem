package com.empmanagement.servlet;

import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empmanagement.dao.ApplicationDao;
import com.empmanagement.entity.User;
import com.empmanagement.entity.Work;

@WebServlet("/ListEmployees")
public class ListEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    String[] months = new DateFormatSymbols().getMonths();
	    
	    request.getSession().setAttribute("months", months);

	    int sYear = 2019;
	    int eYear = 2200;
	    List<Integer> yearList = new ArrayList<Integer>();
	    while(sYear <= eYear) {
	    	yearList.add(sYear);
	    	sYear++;
	    }
	    request.getSession().setAttribute("years", yearList);
	    
	    List<User> userList = ApplicationDao.getInstance().getEmployeeList();
	    List<Work> worksList = ApplicationDao.getInstance().getAllWorkDetails();

		request.getSession().setAttribute("userList", userList);
        request.getSession().setAttribute("works", worksList);
		request.getRequestDispatcher("/manager-dashboard.jsp").forward(request, response);;
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String employeeId = request.getParameter("employee");
	    String month = request.getParameter("month");
		String year = request.getParameter("year");
		List<Work> workList = ApplicationDao.getInstance().getWorkDetails(year,employeeId,month);
		for(Work worker : workList) {
			System.out.println(worker.getYear() + " " + worker.getMonth() + " " + worker.getType());
		}
		request.getSession().removeAttribute("works");
		request.getSession().setAttribute("works", workList);
		
		request.getRequestDispatcher("/manager-dashboard.jsp").forward(request, response);
	}

}
