package com.employee.exception;

public class EmployeeExistedException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	public EmployeeExistedException(String msg)
	{
		super(msg);
	}

}
