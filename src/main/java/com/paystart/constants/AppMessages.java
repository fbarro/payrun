package com.paystart.constants;

public enum AppMessages {
	NO_ACTIVE_EMPLOYEE("No active employee returned."),
	PAYPERIOD_DOES_NOT_EXIST("Pay Period does not exists."),
	PROCESSED_EMPLOYEE_COMPLETE("Processed employee has been completed."),
	PROCESSED_EMPLOYEE("Processed employee."),
	PROCESSED_EMPLOYEE_NO_DTR("No DTR for this period."),
	TOTAL_PROCESSED("Total processed. %s"),
	PAYROLL_IS_FINALIZED("Payroll is marked final. We cannot reprocessed it.");

	private String message;

	private AppMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
