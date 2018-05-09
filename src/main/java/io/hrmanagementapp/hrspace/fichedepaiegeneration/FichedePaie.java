package io.hrmanagementapp.hrspace.fichedepaiegeneration;

import java.util.Calendar;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="FicheDePaie")
public class FichedePaie {
	
	@Id
	private String employeeId;
	private String name;
	private String lastName;
	private String fdpDateOfIssue;
	private String employeePosition;
	private String cnssNum;
	private String bankAccount;
	private double baseSalary;
	private double hourlyPay;
	private double transportAllowance;
	private double performanceBonuse;
	private double otherBonuses;
	private double additionalHours;
	private double CnssDeduction;
	private double socialContribution;
	private double otherDeductions;
	private int leaveDaysCredit;
	private int hoursofAbscencs;
	private double netSalary;
	
	// Constructors
	public FichedePaie() {}
	
	public FichedePaie(String employeeId, String name, String lastName, String fdpDateOfIssue,
	 String employeePosition, String cnssNum, String bankAccount, double baseSalary,
	 double hourlyPay, double transportAllowance, double performanceBonuse, double otherBonuses,
	 double additionalHours, double CnssDeduction, double socialContribution, double otherDeductions,
	 int leaveDaysCredit, int hoursofAbscencs, double netSalary) {
		
		this.employeeId = employeeId;
		this.name = name;
		this.lastName = lastName;
		this.fdpDateOfIssue = fdpDateOfIssue;
		this.employeePosition = employeePosition;
		this.cnssNum = cnssNum;
		this.bankAccount = bankAccount;
		this.baseSalary = baseSalary;
		this.hourlyPay = hourlyPay;
		this.transportAllowance = transportAllowance;
		this.performanceBonuse = performanceBonuse;
		this.otherBonuses = otherBonuses;
		this.additionalHours = additionalHours;
		this.CnssDeduction = CnssDeduction;
		this.socialContribution = socialContribution;
		this.otherDeductions = otherDeductions;
		this.leaveDaysCredit = leaveDaysCredit;
		this.hoursofAbscencs = hoursofAbscencs;
		this.netSalary = netSalary;
	}
	
	
	// Getters and Setters
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFdpDateOfIssue() {
		return fdpDateOfIssue;
	}
	public void setFdpDateOfIssue(String fdpDateOfIssue) {
		this.fdpDateOfIssue = fdpDateOfIssue;
	}
	public String getEmployeePosition() {
		return employeePosition;
	}
	public void setEmployeePosition(String employeePosition) {
		this.employeePosition = employeePosition;
	}
	public String getCnssNum() {
		return this.cnssNum;
	}
	public void setCnssNum(String cnssNum) {
		this.cnssNum = cnssNum;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public double getHourlyPay() {
		return hourlyPay;
	}
	public void setHourlyPay(double hourlyPay) {
		this.hourlyPay = hourlyPay;
	}
	public double getTransportAllowance() {
		return transportAllowance;
	}
	public void setTransportAllowance(double transportAllowance) {
		this.transportAllowance = transportAllowance;
	}
	public double getPerformanceBonuse() {
		return performanceBonuse;
	}
	public void setPerformanceBonuse(double performanceBonuse) {
		this.performanceBonuse = performanceBonuse;
	}
	public double getOtherBoneses() {
		return otherBonuses;
	}
	public void setOtherBoneses(double otherBoneses) {
		this.otherBonuses = otherBoneses;
	}
	public double getAdditionalHours() {
		return additionalHours;
	}
	public void setAdditionalHours(double additionalHours) {
		this.additionalHours = additionalHours;
	}
	public double getCnssDeduction() {
		return CnssDeduction;
	}
	public void setCnssDeduction(double cnssDeduction) {
		CnssDeduction = cnssDeduction;
	}
	public double getSocialContribution() {
		return socialContribution;
	}
	public void setSocialContribution(double socialContribution) {
		this.socialContribution = socialContribution;
	}
	public double getOtherDeductions() {
		return otherDeductions;
	}
	public void setOtherDeductions(double otherDeductions) {
		this.otherDeductions = otherDeductions;
	}
	public int getLeaveDaysCredit() {
		return leaveDaysCredit;
	}
	public void setLeaveDaysCredit(int leaveDaysCredit) {
		this.leaveDaysCredit = leaveDaysCredit;
	}
	public int getHoursofAbscencs() {
		return hoursofAbscencs;
	}
	public void setHoursofAbscencs(int hoursofAbscencs) {
		this.hoursofAbscencs = hoursofAbscencs;
	}
	public double getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}
	
	// App Logic
	
	public void LeaveCreditCalc() {
		Calendar c = Calendar.getInstance();
		if(c.get(Calendar.DAY_OF_MONTH) == 1) {
			this.leaveDaysCredit++;
		}
	}
	
	public void NetSalaryCalc() {
		this.netSalary = (this.baseSalary + this.transportAllowance + this.performanceBonuse
				+ this.otherBonuses + (this.additionalHours * this.hourlyPay))
				- (this.CnssDeduction + this.socialContribution + this.otherDeductions
						+ (this.hoursofAbscencs * this.hourlyPay)); 
	}

}
