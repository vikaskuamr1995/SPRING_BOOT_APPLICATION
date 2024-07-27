package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.Entity.Employee;
import com.employee.Reposiotry.EmployeeRepo;
import com.employee.exception.NoEmployeeExistedException;

@Service
public class EmpServiceImpl implements EmpSerVice {

	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	public void createEmployee(Employee emp) {

		employeeRepo.save(emp);

	}

	@Override
	public List<Employee> getAllEmployee() {

		List<Employee> list = employeeRepo.findAll();

		System.out.println("size of emplist" + list.size());

		if (list.size() < 1) {
			throw new NoEmployeeExistedException(
					"Currently there is not Employee there in database.Please check later");
		}

		System.out.println("list" + list);
		return list;

	}

	@Override
	public Optional<Employee> getEmployeeByMobileNumber(String mobileNumber) {

		Optional<Employee> empCheck = employeeRepo.findBymobileNumber(mobileNumber);

		if (!empCheck.isPresent()) {
			throw new NoEmployeeExistedException("No Employee present on this mobile number:" + mobileNumber);
		}
		return empCheck;
	}

	@Override
	public Employee updateEmployee(int eid, Employee emp) {

		Optional<Employee> existingEmployee = employeeRepo.findById(eid);
		
		System.out.println("employee id:"+existingEmployee.get());

		if (existingEmployee.isPresent()) {
			Employee updateEmployee = existingEmployee.get();

			updateEmployee.setAge(emp.getAge());
			updateEmployee.setMobileNumber(emp.getName());
			updateEmployee.setMobileNumber(emp.getMobileNumber());
			updateEmployee.setSkillSet(emp.getSkillSet());

			Employee updated = employeeRepo.save(updateEmployee);
			return updated;

		} else {
			throw new NoEmployeeExistedException("No Employee present for given id" + emp.getEid());
		}

	}

	@Override
	public void deleteByMobileNumber(String mobileNumber) {
		
		
		Optional<Employee>existingEmployee= employeeRepo.findBymobileNumber(mobileNumber);
		
		if(existingEmployee.isPresent())
		{
			employeeRepo.deleteBymobileNumber(mobileNumber);
		}
		else
		{
			throw new NoEmployeeExistedException("No Employee present for given mobile no" + mobileNumber);
		}
	}



}
