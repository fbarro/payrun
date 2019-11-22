package com.paystart.constants;

public enum ErrorMessages {
	PAY_PERIOD_NOT_FOUND("Payroll period is not existing.");

	private String errorMessage;

	private ErrorMessages(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
