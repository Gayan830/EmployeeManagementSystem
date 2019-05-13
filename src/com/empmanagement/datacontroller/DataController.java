package com.empmanagement.datacontroller;

import java.util.List;

import com.empmanagement.dao.ApplicationDao;
import com.empmanagement.entity.SalaryPayment;
import com.empmanagement.entity.Work;

public class DataController {

	public static SalaryPayment calculateSalary(String year, String id, String month) {

		List<Work> workList = ApplicationDao.getInstance().getWorkDetails(year, id, month);
		String position = ApplicationDao.getInstance().getEmployeePosition(id);
		Double[] payRates = ApplicationDao.getInstance().getSalaryScale(position);

		double salary = payRates[0];
		double compesanation = 0;
		double deductions = 0;
		int daysWorked = workList.size();
		double payment = 0;
		
		

		if (workList != null && daysWorked >= 10) {
			if (daysWorked >= 20) {
				compesanation = (daysWorked - 20) * payRates[1];
				payment = salary + compesanation;
			} else {
				deductions = (20 - daysWorked) * payRates[2];
				payment = salary - deductions;
			}
		}

		return new SalaryPayment(daysWorked, compesanation, deductions, salary, payment);
	}

}
