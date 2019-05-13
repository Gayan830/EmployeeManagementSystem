package com.empmanagement.entity;

public class Promotion {

	private String firstName;
	private String lastName;
	private int yearsWorked;
	private String currentPosition;
	private boolean managerApproval;
	private String department;
	private String employeeId;
	
	public Promotion(int yearsWorked, String currentPosition,boolean managerApproval) {
		this.yearsWorked = yearsWorked;
		this.currentPosition = currentPosition;
		this.managerApproval = managerApproval;
	}
	public Promotion(int yearsWorked, String currentPosition,boolean managerApproval,
			String employeeId,String firstName,String lastName,String department) {
		this(yearsWorked,currentPosition,managerApproval);
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getYearsWorked() {
		return yearsWorked;
	}
	public void setYearsWorked(int yearsWorked) {
		this.yearsWorked = yearsWorked;
	}
	public String getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(String currentPosition) {
		this.currentPosition = currentPosition;
	}
	public boolean getManagerApproval() {
		return managerApproval;
	}
	public void setManagerApproval(boolean managerApproval) {
		this.managerApproval = managerApproval;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
}
