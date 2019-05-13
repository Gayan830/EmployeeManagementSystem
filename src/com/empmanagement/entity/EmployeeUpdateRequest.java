package com.empmanagement.entity;

public class EmployeeUpdateRequest {

	

	private String userName;
	private String passwords;
	private String email;
	private String Department;
	
	public EmployeeUpdateRequest(String userName, String passwords, String email, String department) {
		this.userName = userName;
		this.passwords = passwords;
		this.email = email;
		Department = department;
	}
	

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswords() {
		return passwords;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	
	
}
