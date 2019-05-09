package com.empmanagement.datacontroller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.empmanagement.dao.ApplicationDao;
import com.empmanagement.entity.SalaryPayment;
import com.empmanagement.entity.Work;

public class DataController {

	public SalaryPayment calculateSalary(String year,String id, String month, String position) {

		List<Work> workList = ApplicationDao.getInstance().getWorkDetails(year, id, month);
		Double[] payRates = ApplicationDao.getInstance().getSalaryScale(position);
		double salary = payRates[0];
		double compesanation = 0;
		double deductions = 0;
		int daysWorked = workList.size();
		double payment = 0;
		if (workList != null &&  daysWorked >=10) {
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
