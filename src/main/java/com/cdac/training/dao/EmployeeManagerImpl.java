package com.cdac.training.dao;


import java.util.List;

import org.hibernate.Transaction;

import com.cdac.training.bean.Employee;

import org.hibernate.Session;
import com.cdac.training.session.CreateNewSession;

public class EmployeeManagerImpl implements EmployeeManager {
	private Session session;
	
	public EmployeeManagerImpl() {
		session=CreateNewSession.getSession();
	}

	public Session getSession() {
		return session;
	}

	public Employee getEmployeeById(int empId) {
		Employee employee=null;
		employee=session.get(Employee.class, empId);
		return employee;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployees() {
		return (session.createQuery("from Employee").list());
	}

	public boolean addEmployee(Employee employee) {
		Transaction tx=session.beginTransaction();
		int i=(Integer) session.save(employee);
		
		if(i>0) {
			tx.commit();
			return true;
		}else {
			tx.rollback();
			return false;
		}
	}

	public void updateEmployee(Employee employee) {
		Transaction tx=session.beginTransaction();
		session.update(employee);
		tx.commit();
		System.out.println("Employee Info has been saved...");
	}

	public void deleteEmployee(int empId) {
		Employee employee=null;
		employee=getEmployeeById(empId);
		if(employee!=null) {
			System.out.println(employee+" info found");
			Transaction tx=session.beginTransaction();
			session.delete(employee);
			tx.commit();
			System.out.println(employee+" info deleted");
		}else {
			System.err.println("Entered employee id:"+empId+" not found..");
		}
	}
}