package io.hrmanagementapp.hrspace;

import java.util.Calendar;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {
	
	@Id
	private String id;
	private String name;
	private String lastName;
	private String birthDate;
	private String startDate;
	private int remainingLeaveCredit;	//in days (8h per day)
	private double hourlyPay;
	private double salary;
	
	public Employee() {}
	
	public Employee(String id, String name, String lastName,
			String birthDate, String startDate,
			int remainingLeaveCredit, double hourlyPay, double salary) {
		
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.startDate = startDate;
		this.remainingLeaveCredit = remainingLeaveCredit;
		this.hourlyPay = hourlyPay;
		this.salary = salary;
		
	}
	
	// Getters and Setters
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
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
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public int getRemainingLeaveCredit() {
		return remainingLeaveCredit;
	}
	public void setRemainingLeaveCredit(int remainingLeaveCredit) {
		this.remainingLeaveCredit = remainingLeaveCredit;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getHourlyPay() {
		return hourlyPay;
	}
	public void setHourlyPay(double hourlyPay) {
		this.hourlyPay = hourlyPay;
	}
	
	// App logic
	
	public void calcSalary() {
		
		Calendar c = Calendar.getInstance();
		int numDaysCMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		if(this.remainingLeaveCredit>=0) {
			this.salary = this.hourlyPay * numDaysCMonth *8;
		}else {
			this.salary = this.hourlyPay * (numDaysCMonth + this.remainingLeaveCredit) *8;
		}
	}
	public void CalcRemainingLeaveCredit() {
		Calendar c = Calendar.getInstance();
		if(c.get(Calendar.DAY_OF_MONTH) == 1) {
			this.remainingLeaveCredit++;
		}
	}

}
