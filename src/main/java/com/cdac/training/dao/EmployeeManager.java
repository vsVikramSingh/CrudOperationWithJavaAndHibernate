package com.cdac.training.dao;

import java.util.List;

import com.cdac.training.bean.Employee;


public interface EmployeeManager {
	//1. Get Employee record by passing empId
	Employee getEmployeeById(int empId);
	
	//2. Get All Employees record
	List<Employee> getEmployees();
	
	//3. Add new employee data
	boolean addEmployee(Employee employee);
	
	//4. Modify employee info
	void updateEmployee(Employee employee);
	
	//5. Delete employee info by id
	void deleteEmployee(int empId);
}
