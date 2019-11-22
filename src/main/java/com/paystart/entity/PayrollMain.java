package com.paystart.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	
@Entity
@Table(name = "xin_payroll_main")
public class PayrollMain implements Serializable {
	private static final long serialVersionUID = -5981085472468043743L;

	@Id
	@Column(name = "payroll_main_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "month_year")
	private String monthYear;

	@Column(name = "pay_period")
	private String payPeriod;

	@Column(name = "status")
	private String status;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Column(name = "updated_by")
	private String updatedBy;
	
	public PayrollMain() {}

	public PayrollMain(String monthYear, String payPeriod, String status, LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt,
			String updatedBy) {
		super();
		this.monthYear = monthYear;
		this.payPeriod = payPeriod;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PayrollMain [id=");
		builder.append(id);
		builder.append(", monthYear=");
		builder.append(monthYear);
		builder.append(", payPeriod=");
		builder.append(payPeriod);
		builder.append(", status=");
		builder.append(status);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append(", updatedBy=");
		builder.append(updatedBy);
		builder.append("]");
		return builder.toString();
	}
}
