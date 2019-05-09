package com.empmanagement.entity;

public class LoanRequest {
	private String loanRequestId;
	private double loanAmount;
	private String approvalManager;
	
	
	public LoanRequest(String loanRequestId,double loanAmount, String approvalManager) {
		this.loanAmount = loanAmount;
		this.approvalManager = approvalManager;
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
	

}
