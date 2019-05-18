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
		request.getRequestDispatcher("/view-salary-report.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SalaryPayment salary = (SalaryPayment) request.getSession().getAttribute("report");
		List<Work> works = (List<Work>) request.getSession().getAttribute("works");
		if (ApplicationDao.getInstance().insertIntoPayments(salary, works.get(0).getMonth(), works.get(0).getYear())) {
			System.out.println("Successful Inserted payment");

		}
		request.getRequestDispatcher("/view-salary-report.jsp").forward(request, response);
	}

}
