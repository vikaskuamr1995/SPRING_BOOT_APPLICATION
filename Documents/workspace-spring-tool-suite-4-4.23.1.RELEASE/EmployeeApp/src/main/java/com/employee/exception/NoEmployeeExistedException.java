package com.employee.exception;

public class NoEmployeeExistedException extends RuntimeException{
	
	
	public NoEmployeeExistedException(String msg) {
		super(msg);
	}

}
