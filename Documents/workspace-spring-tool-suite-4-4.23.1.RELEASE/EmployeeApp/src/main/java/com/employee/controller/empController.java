package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.employee.Entity.Employee;
import com.employee.Response.EmployeeResponseMsg;
import com.employee.service.EmpSerVice;

@RestController
@RequestMapping("/app")
public class empController {

	@Autowired
	EmployeeResponseMsg employeeResponseMsg;

	@Autowired
	EmpSerVice empSerVice;

	@PostMapping("/create")
	public ResponseEntity<String> createEmployee(@RequestBody Employee emp) {

		return new ResponseEntity<String>("Employee Created sucessfully", HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllEmployee() {

		List<Employee> list = empSerVice.getAllEmployee();

		EmployeeResponseMsg data = new EmployeeResponseMsg("Employee details fetched sucessfully", list);

		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@GetMapping("/emp/{Mobilenumber}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("Mobilenumber") String mobileNumber) {

		Optional<Employee> emp = empSerVice.getEmployeeByMobileNumber(mobileNumber);

		EmployeeResponseMsg data = new EmployeeResponseMsg(
				"Employee details fetched " + "sucessfully for given mobile number:" + mobileNumber, emp);

		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@PutMapping("/update/{eid}")
	public ResponseEntity<?> updateEmployee(@PathVariable("eid")int eid,@RequestBody Employee employee) {
		
     Employee data= empSerVice.updateEmployee(eid, employee);
     
     EmployeeResponseMsg response=new EmployeeResponseMsg("Employee details updated sucessfullly",data);
     
     return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{number}")
	public ResponseEntity<?>deleteEmployee(@PathVariable("number") String number)
	{
		empSerVice.deleteByMobileNumber(number);
		
		
		return new ResponseEntity<>("Employee Deleted Sucessfully",HttpStatus.OK);
		
		
	}
}
