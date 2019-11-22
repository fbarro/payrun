package com.paystart.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "xin_payroll_summary")
public class PayrollSummary {
	
	@Id
	@Column(name = "payroll_summary_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "employee_id")
	private Integer employeeId;

	@Column(name = "month_year")
	private String monthYear;

	@Column(name = "pay_period")
	private String payPeriod;

	@Column(name = "basic_pay_total")
	private BigDecimal basicPayTotal;

	@Column(name = "nightshift_pay_total")
	private BigDecimal nightShiftPayTotal;

	@Column(name = "ot_pay_total")
	private BigDecimal otPayTotal;

	@Column(name = "gross_pay_total")
	private BigDecimal grossPayTotal;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Column(name = "updated_by")
	private String updatedBy;

	public PayrollSummary() {
		super();
	}

	public PayrollSummary(Integer employeeId, String monthYear, String payPeriod, 
			BigDecimal basicPayTotal, BigDecimal nightShiftPayTotal, BigDecimal otPayTotal, BigDecimal grossPayTotal,
			LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy) {
		super();
		this.employeeId = employeeId;
		this.monthYear = monthYear;
		this.payPeriod = payPeriod;
		this.basicPayTotal = basicPayTotal;
		this.nightShiftPayTotal = nightShiftPayTotal;
		this.otPayTotal = otPayTotal;
		this.grossPayTotal = grossPayTotal;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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

	public BigDecimal getBasicPayTotal() {
		return basicPayTotal;
	}

	public void setBasicPayTotal(BigDecimal basicPayTotal) {
		this.basicPayTotal = basicPayTotal;
	}

	public BigDecimal getNightShiftPayTotal() {
		return nightShiftPayTotal;
	}

	public void setNightShiftPayTotal(BigDecimal nightShiftPayTotal) {
		this.nightShiftPayTotal = nightShiftPayTotal;
	}

	public BigDecimal getOtPayTotal() {
		return otPayTotal;
	}

	public void setOtPayTotal(BigDecimal otPayTotal) {
		this.otPayTotal = otPayTotal;
	}

	public BigDecimal getGrossPayTotal() {
		return grossPayTotal;
	}

	public void setGrossPayTotal(BigDecimal grossPayTotal) {
		this.grossPayTotal = grossPayTotal;
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

}
