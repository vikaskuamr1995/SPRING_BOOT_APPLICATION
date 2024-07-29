package com.Product.App.Exception;

public class ExcelDownloadFailed extends RuntimeException {

	String msg;

	public ExcelDownloadFailed(String msg) {
		super(msg);
		
	}

}
