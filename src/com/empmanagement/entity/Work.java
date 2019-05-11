package com.empmanagement.entity;

import java.time.LocalDate;

public class Work {
	
	
	
	
	private String month;
	private String year;
	private String type;
	
	public Work(String month, String year, String type) {
		this.month = month;
		this.year = year;
		this.type = type;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
}
