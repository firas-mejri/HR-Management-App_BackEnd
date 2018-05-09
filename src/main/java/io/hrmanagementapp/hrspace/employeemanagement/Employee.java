package io.hrmanagementapp.hrspace.employeemanagement;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Employee")
public class Employee {
	
	@Id
	private String id;
	private String name;
	private String lastName;
	private String birthDate;
	private String startDate;
	private int remainingLeaveCredit;	//in days (8h per day)
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

}
