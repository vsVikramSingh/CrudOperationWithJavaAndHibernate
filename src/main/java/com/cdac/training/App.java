package com.cdac.training;

import java.util.List;
import java.util.Scanner;

import com.cdac.training.bean.Employee;
import com.cdac.training.dao.EmployeeManager;
import com.cdac.training.dao.EmployeeManagerImpl;

public class App 
{
	public static void main( String[] args )
    {
        Scanner keyboard=new Scanner(System.in);
        EmployeeManager manager=new EmployeeManagerImpl();
        int empId;
        Employee emp=null;
        int choice=1;
        while(choice!=0) {
        	System.out.print("\nEmployee Manager Application");
        	System.out.print("\n-----------------------------");
        	System.out.print("\n1. Display Employee Info By Id");
        	System.out.print("\n2. Display All Employees Info");
        	System.out.print("\n3. Add New Employee Info");
        	System.out.print("\n4. Update Existing Employee Info");
        	System.out.print("\n5. Delete Existing Employee Info By Id");
        	System.out.print("\n0. Terminate Application");
        	System.out.print("\n-----------------------------");
        	System.out.print("\nPlease Enter your choice(0-5):");
        	choice=keyboard.nextInt(); 
        	switch(choice) {
        	case 1:
        		System.out.println("Enter employee id to get employee info:");
        		empId=keyboard.nextInt();
        		emp=manager.getEmployeeById(empId);
        		if(emp!=null) {
        			System.out.println(emp);
        		}else {
        			System.err.println("Entered employee id:"+empId+" not found..");
        		}
        		break;
        	case 2:
        		List<Employee> list=manager.getEmployees();
        		for(Employee employee:list) {
        			System.out.println(employee);
        		}
        		break;
        	case 3:
        		emp=new Employee();
        		System.out.println("Enter employee Department:");
        		emp.setDeptId(keyboard.nextInt());
        		System.out.println("Enter employee First Name:");
        		emp.setFname(keyboard.next());
        		System.out.println("Enter employee Designation:");
        		emp.setDesignation(keyboard.next());
        		System.out.println("Enter employee Salary:");
        		emp.setSalary(keyboard.nextDouble());
        		boolean status=manager.addEmployee(emp);
        		if(status) {
        			System.out.println("employee info saved ...");
        		}else {
        			System.out.println("Transaction failed ...");
        		}
        		break;
        	case 4:
        		System.out.println("Enter employee id to get employee info:");
        		empId=keyboard.nextInt();
        		emp=manager.getEmployeeById(empId);
        		if(emp!=null) {
        			System.out.println("Existing data:"+emp);
        			System.out.println("Enter employee Department:");
            		emp.setDeptId(keyboard.nextInt());
            		System.out.println("Enter employee First Name:");
            		emp.setFname(keyboard.next());
            		System.out.println("Enter employee Designation:");
            		emp.setDesignation(keyboard.next());
            		System.out.println("Enter employee Salary:");
            		emp.setSalary(keyboard.nextDouble());
            		manager.updateEmployee(emp);
        			
        		}else {
        			System.err.println("Entered employee id:"+empId+" not found..");
        		}
        		break;
        	case 5:
        		System.out.println("Enter employee id to get employee info:");
        		empId=keyboard.nextInt();
        		manager.deleteEmployee(empId);
        		break;
        	case 0:
        		System.out.println("Thanks for using app, app terminated..");
        		break;
        	default:
        		System.out.println("Valid options are 0 - 5 only...");
        	}
        }
    }
}
