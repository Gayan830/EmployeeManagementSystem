package com.empmanagement.entity;

public class Promotion {


	private int yearsWorked;
	private String currentPosition;
	private String managerApproval;
	private String employeeId;
	
	public Promotion(int yearsWorked, String currentPosition,String managerApproval) {
		this.yearsWorked = yearsWorked;
		this.currentPosition = currentPosition;
		this.managerApproval = managerApproval;
	}
	public Promotion(int yearsWorked, String currentPosition,String managerApproval,String employeeId) {
		this(yearsWorked,currentPosition,managerApproval);
		this.employeeId = employeeId;
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
	public String getManagerApproval() {
		return managerApproval;
	}
	public void setManagerApproval(String managerApproval) {
		this.managerApproval = managerApproval;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
}
