package com.empmanagement.entity;

import java.time.LocalDate;

public class Work {
	
	private LocalDate date;
	private String type;
	
	public Work(LocalDate date, String type) {
		this.date = date;
		this.type = type;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
