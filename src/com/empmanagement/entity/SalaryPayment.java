package com.empmanagement.entity;

import java.time.LocalDate;

public class SalaryPayment {

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	private int id;
	private int daysWorked;
	private double compasanation;
	private double deduction;
	private LocalDate date;
	private double salary;
	private double payment;
	private String month;
	private String year;
	private String employeeId;


	public SalaryPayment(int daysWorked, double compasanation, double deduction, double salary, double payment) {
		this.daysWorked = daysWorked;
		this.compasanation = compasanation;
		this.deduction = deduction;
		this.date = LocalDate.now();
		this.salary = salary;
		this.payment = payment;
	}

	public SalaryPayment( double compasanation, double deduction,
			double salary, double payment, String month, String year,
			LocalDate date ,int id) {
		this.compasanation = compasanation;
		this.deduction = deduction;
		this.salary = salary;
		this.payment = payment;
		this.date = date;
		this.month = month;
		this.year = year;
		this.id = id;
	}

	

	
	public int getDaysWorked() {
		return daysWorked;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public double getPayment() {
		return payment;
	}

	public void setDaysWorked(int daysWorked) {
		this.daysWorked = daysWorked;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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
