package com.employee.Response;

import org.springframework.stereotype.Component;

@Component
public class EmployeeResponseMsg {
	String msg;
	Object data;
	
	
	
	

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public EmployeeResponseMsg( String msg,Object data) {
		super();
		this.data = data;
		this.msg = msg;
	}

	public EmployeeResponseMsg() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EmployeeResponseMsg [data=" + data + ", msg=" + msg + "]";
	}
	
	
}
