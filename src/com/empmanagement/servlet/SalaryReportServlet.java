package com.empmanagement.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empmanagement.dao.ApplicationDao;
import com.empmanagement.entity.SalaryPayment;
import com.empmanagement.entity.Work;

@WebServlet("/SalaryReportServlet")
public class SalaryReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("This runs");
		
		SalaryPayment salary = (SalaryPayment) request.getSession().getAttribute("report");
		String empId = (String) request.getSession().getAttribute("empId");
		salary.setEmployeeId(empId);
		if (ApplicationDao.getInstance().insertIntoPayments(salary, salary.getMonth(), salary.getYear())) {
			System.out.println("Successful Inserted payment");

		}
		request.getRequestDispatcher("/view-salary-report.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/view-salary-report.jsp").forward(request, response);
	}

}
