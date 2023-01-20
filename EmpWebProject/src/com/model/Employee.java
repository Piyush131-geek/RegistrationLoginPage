package com.model;

public class Employee {
	private int empId;
	private String empName;
	private double salary;
	private String gender;
	private String emailId;
	private String password;
	
	public Employee() {
		super();
	}

	public Employee(int empId, String empName, double salary, String gender, String emailId, String password) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.gender = gender;
		this.emailId = emailId;
		this.password = password;
	}

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", gender=" + gender
				+ ", emailId=" + emailId + ", password=" + password + "]";
	}	
}
