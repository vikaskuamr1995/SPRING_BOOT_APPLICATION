package com.Product.App.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class errorResponse {

	String apiPath;

	HttpStatus errorCode;

	String errormsg;

	LocalDateTime errorTime;

	@Override
	public String toString() {
		return "errorResponse [apiPath=" + apiPath + ", errorCode=" + errorCode + ", errormsg=" + errormsg
				+ ", errorTime=" + errorTime + "]";
	}

	public String getApiPath() {
		return apiPath;
	}

	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}

	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public LocalDateTime getErrorTime() {
		return errorTime;
	}

	public void setErrorTime(LocalDateTime errorTime) {
		this.errorTime = errorTime;
	}

	public errorResponse(String apiPath, HttpStatus errorCode, String errormsg, LocalDateTime errorTime) {

		this.apiPath = apiPath;
		this.errorCode = errorCode;
		this.errormsg = errormsg;
		this.errorTime = errorTime;
	}

	public errorResponse() {

	}

}
