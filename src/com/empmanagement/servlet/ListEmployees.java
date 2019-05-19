package com.empmanagement.servlet;

import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empmanagement.dao.ApplicationDao;
import com.empmanagement.datacontroller.DataController;
import com.empmanagement.entity.Loan;
import com.empmanagement.entity.Promotion;
import com.empmanagement.entity.SalaryPayment;
import com.empmanagement.entity.User;
import com.empmanagement.entity.Work;

@WebServlet("/ListEmployees")
public class ListEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		if (command == null) {
			command = "LOAD";
		}

		switch (command) {
		case "LOAD":
			loadData(request, response);
			break;
		case "APPROVE":
			approvePromotion(request, response);
			break;
		case "SEARCH":
			searchRecords(request, response);
			break;
		case "APPROVE LOAN":
			approveLoans(request, response);
			break;
		case "VIEW REPORT":
			viewReport(request, response);
			break;
		}

	}

	//send the notifications to the requested employees when request approved by the manager.
	private void approveLoans(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("empId");
		int index = Integer.parseInt(request.getParameter("index"));
		List<Loan> loans = (List<Loan>) request.getSession().getAttribute("loans");
		System.out.println(loans.get(index).getLoanAmount());
		String specific = "Amount: " +loans.get(index).getLoanAmount() +
						" Installment: " + loans.get(index).getInstallment() + 
						" Re-payment years: " + loans.get(index).getRePaymentYears()+".";
		ApplicationDao.getInstance().approveLoan(id);
		ApplicationDao.getInstance().insertNotification(id, "yes", "loan", specific);
		loadData(request,response);
	}

	
	private void loadData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] months = new DateFormatSymbols().getMonths();
		request.getSession().setAttribute("months", months);

		int sYear = 2000;
		int eYear = 2100;
		List<Integer> yearList = new ArrayList<Integer>();
		while (sYear <= eYear) {
			yearList.add(sYear);
			sYear++;
		}
		List<Promotion> promotions = ApplicationDao.getInstance().getPromotionRequest();
		List<Loan> loans = ApplicationDao.getInstance().getLoanRequests();
				
		request.getSession().setAttribute("promotions", promotions);
		request.getSession().setAttribute("years", yearList);
		request.getSession().setAttribute("loans",loans);
		
		List<User> userList = ApplicationDao.getInstance().getEmployeeList();
		List<Work> worksList = ApplicationDao.getInstance().getAllWorkDetails();
		List<String> positions = ApplicationDao.getInstance().getPositions();

		request.getSession().setAttribute("positions",positions);
		request.getSession().setAttribute("userList", userList);
		request.getSession().setAttribute("works", worksList);
		request.getRequestDispatcher("/manager-dashboard.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	
	private void searchRecords(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String employeeId = request.getParameter("employee");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		
		List<Work> workList = ApplicationDao.getInstance().getWorkDetails(year, employeeId, month);
		SalaryPayment salary = DataController.calculateSalary(year, employeeId, month);
		salary.setEmployeeId(employeeId);
		request.getSession().removeAttribute("works");
		request.getSession().setAttribute("works", workList);
		request.getSession().setAttribute("report", salary);
		request.getSession().setAttribute("empId", employeeId);
		request.getRequestDispatcher("/manager-dashboard.jsp").forward(request, response);
	}
	
	private void viewReport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/SalaryReport").forward(request,response);
	}

	private void approvePromotion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String selectedPromotion = request.getParameter("pos");
		ApplicationDao.getInstance().promote(id,selectedPromotion);
		ApplicationDao.getInstance().insertNotification(id,"yes","promotion",selectedPromotion);
		loadData(request,response);
	}

}
