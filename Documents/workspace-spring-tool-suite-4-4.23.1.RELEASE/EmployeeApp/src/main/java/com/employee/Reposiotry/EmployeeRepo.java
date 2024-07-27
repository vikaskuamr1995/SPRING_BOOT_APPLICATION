package com.employee.Reposiotry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.Entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	
	Optional<Employee> findBymobileNumber(String mobileNumber);
	
	
 public void deleteBymobileNumber(String mobileNumber);

}
