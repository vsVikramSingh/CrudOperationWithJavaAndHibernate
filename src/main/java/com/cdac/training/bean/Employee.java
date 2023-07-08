package com.cdac.training.bean;

public class Employee {
	private int empId;
	private String fname;
	private String designation;
	private int deptId;
	private double salary;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Employee() {
	}
	public Employee(int empId, String fname, String designation, int deptId, double salary) {
		this.empId = empId;
		this.fname = fname;
		this.designation = designation;
		this.deptId = deptId;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "\nEmployee --:" + empId + ", " + fname + ", " + 
	designation + ", " + deptId + ", " + salary;
	}
}