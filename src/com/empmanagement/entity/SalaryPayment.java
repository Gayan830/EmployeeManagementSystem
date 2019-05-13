package com.empmanagement.entity;

import java.time.LocalDate;

public class SalaryPayment {

	private int daysWorked;
	private double compasanation;
	private double deduction;
	private LocalDate Date;
	private double salary;
	private double payment;


	public SalaryPayment(int daysWorked, double compasanation, double deduction, double salary, double payment) {
		this.daysWorked = daysWorked;
		this.compasanation = compasanation;
		this.deduction = deduction;
		this.Date = LocalDate.now();
		this.salary = salary;
		this.payment = payment;
	}

	public int getDaysWorked() {
		return daysWorked;
	}

	public double getPayment() {
		return payment;
	}

	public void setDaysWorked(int daysWorked) {
		this.daysWorked = daysWorked;
	}

	public LocalDate getDate() {
		return Date;
	}

	public void setDate(LocalDate date) {
		Date = date;
	}

	public double getCompasanation() {
		return compasanation;
	}

	public void setCompasanation(double compasanation) {
		this.compasanation = compasanation;
	}

	public double getDeduction() {
		return deduction;
	}

	public void setDeduction(double deduction) {
		this.deduction = deduction;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
