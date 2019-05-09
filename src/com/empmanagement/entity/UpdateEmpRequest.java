package com.empmanagement.entity;

public class UpdateEmpRequest {

	private String userName;
	private String password;
	private String email;
	private String department;
	
	public UpdateEmpRequest(String userName, String password, String email, String department) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.department = department;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
