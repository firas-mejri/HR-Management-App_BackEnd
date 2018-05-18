package io.hrmanagementapp.hrspace.leaverequests;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="LeaveRequests")
public class LeaveRequest {
	
	@Id
	private String requestId;
	private String empId;
	private String fullName;
	private int leaveDaysCredit;
	private String leaveDate;
	private int numberDays;
	private String leaveReason;
	private String hrAnswer;
	
	public LeaveRequest() {}
	public LeaveRequest(String requestId, String empId, String fullName,
			int leaveDaysCredit, String leaveDate, int numberDays, String leaveReason, String hrAnswer) {
		
		super();
		this.requestId = requestId;
		this.empId = empId;
		this.fullName = fullName;
		this.leaveDaysCredit = leaveDaysCredit;
		this.leaveDate = leaveDate;
		this.numberDays = numberDays;
		this.hrAnswer = hrAnswer;
		this.leaveReason = leaveReason;
	}
	
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getLeaveDaysCredit() {
		return leaveDaysCredit;
	}
	public void setLeaveDaysCredit(int leaveDaysCredit) {
		this.leaveDaysCredit = leaveDaysCredit;
	}
	public String getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}
	public int getNumberDays() {
		return numberDays;
	}
	public void setNumberDays(int numberDays) {
		this.numberDays = numberDays;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	public String getHrAnswer() {
		return hrAnswer;
	}
	public void setHrAnswer(String hrAnswer) {
		this.hrAnswer = hrAnswer;
	}
	
	

}
