package com.paystart.exceptions;

import com.paystart.constants.ErrorMessages;

public class PayrollExistsException extends RuntimeException {
	private static final long serialVersionUID = 5465824649343629879L;

	public PayrollExistsException(String message) {
		super(message);
	}
	
	public PayrollExistsException(ErrorMessages message) {
		super(message.getErrorMessage());
	}

	public PayrollExistsException(String message, Throwable throwable) {
		super(message, throwable);
	}
}