package com.paystart.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.paystart.model.BaseBean;
import com.paystart.params.PayrollRunParams;

public class PayrollDetailDTO extends BaseBean {
	@JsonProperty("params")
	private PayrollRunParams payrollRunParams;

	@JsonProperty("totalProcessed")
	private Integer totalProcessed;
	
	@JsonProperty("totalUnProcessed")
	private Integer totalUnProcessed;
	
	@JsonProperty("message")
	private String message;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;

	public PayrollDetailDTO() {
		super();
	}

	public PayrollDetailDTO(PayrollRunParams payrollRunParams, Integer totalProcessed, Integer totalUnProcessed, LocalDateTime timestamp) {
		super();
		this.payrollRunParams = payrollRunParams;
		this.totalProcessed = totalProcessed;
		this.timestamp = timestamp;
	}
	
	public PayrollDetailDTO(PayrollRunParams payrollRunParams, Integer totalProcessed, Integer totalUnProcessed
			, String message, LocalDateTime timestamp) {
		super();
		this.payrollRunParams = payrollRunParams;
		this.totalProcessed = totalProcessed;
		this.totalUnProcessed = totalUnProcessed;
		this.message = message;
		this.timestamp = timestamp;
	}

	public PayrollRunParams getPayrollRunParams() {
		return payrollRunParams;
	}

	public void setPayrollRunParams(PayrollRunParams payrollRunParams) {
		this.payrollRunParams = payrollRunParams;
	}

	public Integer getTotalProcessed() {
		return totalProcessed;
	}

	public void setTotalProcessed(Integer totalProcessed) {
		this.totalProcessed = totalProcessed;
	}
	
	public Integer getTotalUnProcessed() {
		return totalUnProcessed;
	}

	public void setTotalUnProcessed(Integer totalUnProcessed) {
		this.totalUnProcessed = totalUnProcessed;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PayrollDetailDTO [payrollRunParams=");
		builder.append(payrollRunParams);
		builder.append(", totalProcessed=");
		builder.append(totalProcessed);
		builder.append(", totalUnProcessed=");
		builder.append(totalUnProcessed);
		builder.append(", message=");
		builder.append(message);
		builder.append(", timestamp=");
		builder.append(timestamp);
		builder.append("]");
		return builder.toString();
	}
}
