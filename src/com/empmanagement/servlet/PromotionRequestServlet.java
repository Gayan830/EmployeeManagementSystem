package com.empmanagement.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empmanagement.dao.ApplicationDao;
import com.empmanagement.entity.Promotion;
import com.empmanagement.entity.User;


@WebServlet("/PromotionRequestServlet")
public class PromotionRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/req-promotion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		String empId = user.getEmployeeId();
		int yearsWorked = Integer.parseInt(request.getParameter("yearsWorked"));
		String department = request.getParameter("department");
		Promotion promotion = new Promotion(yearsWorked,user.getPosition(),"no",user.getEmployeeId(),user.getFirstName(),user.getLastName(),user.getDepartment());
		ApplicationDao.getInstance().submitPromotionRequest(promotion);
		request.getRequestDispatcher("/req-promotion.jsp").forward(request, response);;
		
		
	}

}
