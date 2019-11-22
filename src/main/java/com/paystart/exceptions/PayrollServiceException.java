package com.paystart.exceptions;

import com.paystart.constants.ErrorMessages;

public class PayrollServiceException extends RuntimeException {
	private static final long serialVersionUID = -9118665124956652774L;

	public PayrollServiceException(String message) {
		super(message);
	}
	
	public PayrollServiceException(ErrorMessages message) {
		super(message.getErrorMessage());
	}

	public PayrollServiceException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
