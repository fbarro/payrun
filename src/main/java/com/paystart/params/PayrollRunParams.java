package com.paystart.params;

import java.time.LocalDate;
import java.time.YearMonth;

import com.paystart.constants.AppConstant;
import com.paystart.util.DateUtil;

public class PayrollRunParams {
	private String employeeId;
	private String monthYear;
	private String payPeriod;
	private String attendanceFrom;
	private String attendanceTo;
	private String userId;
	
	public PayrollRunParams(String employeeId, String monthYear, String payPeriod, String attendanceFrom,
			String attendanceTo, String userId) {
		super();
		this.employeeId = employeeId;
		this.monthYear = monthYear;
		this.payPeriod = payPeriod;
		this.attendanceFrom = attendanceFrom;
		this.attendanceTo = attendanceTo;
		this.userId = userId;
	}

	public PayrollRunParams(String monthYear, String payPeriod, String employeeId, String userId) {
		super();
		this.employeeId = employeeId;
		this.monthYear = monthYear;
		this.payPeriod = payPeriod;
		this.userId = userId;
	}

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}

	public String getPayPeriod() {
		return payPeriod;
	}

	public void setPayPeriod(String payPeriod) {
		this.payPeriod = payPeriod;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getAttendanceFrom() {
		return attendanceFrom;
	}

	public void setAttendanceFrom(String attendanceFrom) {
		this.attendanceFrom = monthYear+AppConstant.DASH+attendanceFrom;
	}

	public String getAttendanceTo() {
		return attendanceTo;
	}

	public void setAttendanceTo(String attendanceTo) {
		if(AppConstant.LAST_DAY_31.equals(attendanceTo)) {
			String[] monYearArr = monthYear.split(AppConstant.DASH);
			Integer year = Integer.valueOf(monYearArr[0]);
			Integer month = Integer.valueOf(monYearArr[1]);
					
			LocalDate lastDayOfMonthYear = YearMonth.of(year, month).atEndOfMonth();
			
			this.attendanceTo = DateUtil.toStringDate(lastDayOfMonthYear, DateUtil.YYYY_MM_DD);
		} else {
			this.attendanceTo = monthYear+AppConstant.DASH+attendanceTo;
		}
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PayrollRunParams [employeeId=");
		builder.append(employeeId);
		builder.append(", monthYear=");
		builder.append(monthYear);
		builder.append(", payPeriod=");
		builder.append(payPeriod);
		builder.append(", attendanceFrom=");
		builder.append(attendanceFrom);
		builder.append(", attendanceTo=");
		builder.append(attendanceTo);
		builder.append(", userId=");
		builder.append(userId);
		builder.append("]");
		return builder.toString();
	}
}
