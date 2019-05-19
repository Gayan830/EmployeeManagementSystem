package com.empmanagement.datacontroller;

import java.util.ArrayList;
import java.util.List;

import com.empmanagement.dao.ApplicationDao;
import com.empmanagement.entity.Loan;
import com.empmanagement.entity.Notification;
import com.empmanagement.entity.SalaryPayment;
import com.empmanagement.entity.Work;

public class DataController {

	public static SalaryPayment calculateSalary(String year, String id, String month) {

		List<Work> workList = ApplicationDao.getInstance().getWorkDetails(year, id, month);
		String position = ApplicationDao.getInstance().getEmployeePosition(id);
		System.out.println(position);
		List<Double> payRates = ApplicationDao.getInstance().getSalaryScale(position);
//		System.out.println(payRates[0]);
		
		double salary = payRates.get(0);
		
		double compesanation = 0;
		double deductions = 0;
		int daysWorked = workList.size();
		double payment = 0;

		if (workList != null && daysWorked >= 10) {
			if (daysWorked >= 20) {
				compesanation = (daysWorked - 20) * payRates.get(1);
				payment = salary + compesanation;
			} else {
				deductions = (20 - daysWorked) * payRates.get(2);
				payment = salary - deductions;
			}
		}

		return new SalaryPayment(daysWorked, compesanation, deductions, salary, payment);
	}

	public static List<Loan> calculateMaximumAllowableAmounts(String position) {
		List<Loan> loanPreference = new ArrayList<Loan>();
		double salary = ApplicationDao.getInstance().getSalary(position);
		double amount = 0;

		for (int i = 3; i <= 10; i++) {
			Loan loan = new Loan();
			if (i > 5) {
				amount = salary * 20;
				double installment = amount / (12 * i);
				loan.setLoanAmount(amount);
				loan.setRePaymentYears(i);
				loan.setInstallment(installment);
				loanPreference.add(loan);
			} else {
				amount = salary * 10;
				double installment = amount / (12 * i);
				loan.setLoanAmount(amount);
				loan.setInstallment(installment);
				loan.setRePaymentYears(i);
				loanPreference.add(loan);
			}
		}
		return loanPreference;
	}

}
