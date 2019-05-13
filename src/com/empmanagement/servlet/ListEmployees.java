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
		}

	}

	private void loadData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] months = new DateFormatSymbols().getMonths();
		request.getSession().setAttribute("months", months);

		int sYear = 2019;
		int eYear = 2200;
		List<Integer> yearList = new ArrayList<Integer>();
		while (sYear <= eYear) {
			yearList.add(sYear);
			sYear++;
		}
		List<Promotion> promotions = ApplicationDao.getInstance().getPromotionRequest();
		System.out.println(promotions.get(0).getDepartment());

		Collections.sort(promotions, new Comparator<Promotion>() {
			public int compare(Promotion p1, Promotion p2) {
				if (p1.getManagerApproval() == p2.getManagerApproval()) {
					return 0;
				} else if (p1.getManagerApproval()) {
					return 1;
				} else if (p2.getManagerApproval()) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		request.getSession().setAttribute("promotions", promotions);
		request.getSession().setAttribute("years", yearList);

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
		for (Work worker : workList) {
			System.out.println(worker.getYear() + " " + worker.getMonth() + " " + worker.getType());
		}
		request.getSession().removeAttribute("works");
		request.getSession().setAttribute("works", workList);
		SalaryPayment salary = DataController.calculateSalary(year, employeeId, month);
		if(ApplicationDao.getInstance().insertIntoPayments(salary)) {
			System.out.println("Inserted Successfully to payment table.");
		}
		request.getSession().setAttribute("report", salary);
		request.getRequestDispatcher("/manager-dashboard.jsp").forward(request, response);
	}

	private void approvePromotion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String selectedPromotion = request.getParameter("pos");
		ApplicationDao.getInstance().promote(id,selectedPromotion);
		request.getSession().removeAttribute("command");
		request.getRequestDispatcher("/manager-dashboard.jsp").forward(request, response);
		
		
	}

}
