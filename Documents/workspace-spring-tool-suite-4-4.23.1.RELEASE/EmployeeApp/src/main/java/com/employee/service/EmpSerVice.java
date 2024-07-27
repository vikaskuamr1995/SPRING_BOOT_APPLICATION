package com.employee.service;

import java.util.List;
import java.util.Optional;

import com.employee.Entity.Employee;

public interface EmpSerVice {

	
	public void createEmployee(Employee emp);
	public Employee updateEmployee(int eid,Employee emp);
	
	List<Employee>getAllEmployee();
	
	Optional<Employee> getEmployeeByMobileNumber(String mobileNumber);
	
	public void deleteByMobileNumber(String mobileNumber);
}
