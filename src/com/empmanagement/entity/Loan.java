package com.empmanagement.entity;

public class Loan {

	private int id;
	private double loanAmount;
	private int rePaymentYears;
	private double installment;
	private String approvalManager;
	private String purpose;
	private String name;
	private String empId;

	public Loan(double loanAmount,  int rePaymentYears,double installment, String approvalManager, String purpose) {
		this.loanAmount = loanAmount;
		this.approvalManager = approvalManager;
		this.rePaymentYears = rePaymentYears;
		this.installment = installment;
		this.purpose = purpose;
	}
	
	

	public Loan(int id,double loanAmount, int rePaymentYears, double installement,
			String approvalManager, String purpose,String name,String empId) {
		this(loanAmount,rePaymentYears,installement,approvalManager,purpose);
		this.name = name;
		this.id = id;
		this.empId = empId;
		
	}
	
	public Loan() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getApprovalManager() {
		return approvalManager;
	}
	public void setApprovalManager(String approvalManager) {
		this.approvalManager = approvalManager;
	}
	
	public int getRePaymentYears() {
		return rePaymentYears;
	}

	public void setRePaymentYears(int rePaymentYears) {
		this.rePaymentYears = rePaymentYears;
	}

	public double getInstallment() {
		return installment;
	}

	public void setInstallment(double installement) {
		this.installment = installement;
	}
	
	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	
}
