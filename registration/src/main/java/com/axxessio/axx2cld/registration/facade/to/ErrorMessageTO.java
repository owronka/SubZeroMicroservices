package com.axxessio.axx2cld.registration.facade.to;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ErrorMessageTO extends GenericTO{
	String error;
	int    error_code;
	String error_description;
	String error_uri;
	
	@JsonCreator
	public ErrorMessageTO (String newError, int newErrorCode, String newErrorDescription, String newErrorURI) {
		this.error = newError;
		this.error_code = newErrorCode;
		this.error_description = newErrorDescription;
		this.error_uri = newErrorURI;
	}

	public String getError() {
		return error;
	}

	public int getErrorCode () {
		return this.error_code;
	}
	
	public String getError_description() {
		return error_description;
	}

	public String getError_uri() {
		return error_uri;
	}
}
