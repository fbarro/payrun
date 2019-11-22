package com.paystart.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.paystart.constants.ErrorMessages;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class PayrollPeriodNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 2361975088696041501L;

	public PayrollPeriodNotFoundException(String message) {
		super(message);
	}
	
	public PayrollPeriodNotFoundException(ErrorMessages message) {
		super(message.getErrorMessage());
	}

	public PayrollPeriodNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}
}