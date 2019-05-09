package com.empmanagement.entity;

import java.util.UUID;

public class User {
	
	private String employeeId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private String telephone;
	private String address;
	private String role;
	private String position;
	private String department;
	
	public User(String firstName, String lastName, String userName, String password, String email,
			String telephone, String address, String role, String position, String department) {
		this.employeeId = UUID.randomUUID().toString();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.telephone = telephone;
		this.address = address;
		this.role = role;
		this.position = position;
		this.department = department;
	}
	
	public User(String employeeId,String firstName, String lastName) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public User(String employeeId, String firstName, String lastName, String userName, String password, String email,
			String telephone, String address, String role, String position, String department) {
		this(firstName,lastName,userName,password,email,telephone,address,role,position,department);
		this.employeeId = employeeId;
	}	
	
	public String getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
}
