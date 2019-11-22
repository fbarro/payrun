package com.paystart.model;

import com.paystart.entity.Employee;

public class Result {
	private Employee employee;
	private String message;
	
	public Result(Employee employee, String message) {
		super();
		this.employee = employee;
		this.message = message;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Result [employee=");
		builder.append(employee);
		builder.append(", message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}
}

 