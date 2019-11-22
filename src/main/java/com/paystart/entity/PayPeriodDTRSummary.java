package com.paystart.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="xin_payperiod_dtr_summary")
public class PayPeriodDTRSummary implements Serializable  {
	private static final long serialVersionUID = -1271067493821453164L;

	@Id
	@Column(name = "hours_summary_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "employee_id")
	private Integer employeeId;
	
	@Column(name = "monthYear")
	private String monthYear;
	
	@Column(name = "payPeriod")
	private String payPeriod;
	
	@Column(name = "regular_hours")
	private BigDecimal regularHours;
	
	@Column(name = "nightshift_hours")
	private BigDecimal nightShiftHours;
	
	@Column(name = "ot_hours")
	private BigDecimal otHours;
	
	@Column(name = "legal_hours")
	private BigDecimal legalHours;
	
	@Column(name = "legal_night_hours")
	private BigDecimal legalNightHours;
	
	@Column(name = "legal_ot_hours")
	private BigDecimal legalOtHours;
	
	@Column(name = "special_hours")
	private BigDecimal specialHours;
	
	@Column(name = "special_night_hours")
	private BigDecimal specialNightHours;
	
	@Column(name = "special_ot_hours")
	private BigDecimal specialOtHours;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Column(name = "updated_by")
	private String updatedBy;
	
	public PayPeriodDTRSummary() {
		super();
	}

	public PayPeriodDTRSummary(Integer id, Integer employeeId, String monthYear, String payPeriod,
			BigDecimal regularHours, BigDecimal nightShiftHours, BigDecimal otHours, BigDecimal legalHours,
			BigDecimal legalNightHours, BigDecimal legalOtHours, BigDecimal specialHours, BigDecimal specialNightHours,
			BigDecimal specialOtHours, LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt,
			String updatedBy) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.monthYear = monthYear;
		this.payPeriod = payPeriod;
		this.regularHours = regularHours;
		this.nightShiftHours = nightShiftHours;
		this.otHours = otHours;
		this.legalHours = legalHours;
		this.legalNightHours = legalNightHours;
		this.legalOtHours = legalOtHours;
		this.specialHours = specialHours;
		this.specialNightHours = specialNightHours;
		this.specialOtHours = specialOtHours;
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

	public BigDecimal getRegularHours() {
		return regularHours;
	}

	public void setRegularHours(BigDecimal regularHours) {
		this.regularHours = regularHours;
	}

	public BigDecimal getNightShiftHours() {
		return nightShiftHours;
	}

	public void setNightShiftHours(BigDecimal nightShiftHours) {
		this.nightShiftHours = nightShiftHours;
	}

	public BigDecimal getOtHours() {
		return otHours;
	}

	public void setOtHours(BigDecimal otHours) {
		this.otHours = otHours;
	}

	public BigDecimal getLegalHours() {
		return legalHours;
	}

	public void setLegalHours(BigDecimal legalHours) {
		this.legalHours = legalHours;
	}

	public BigDecimal getLegalNightHours() {
		return legalNightHours;
	}

	public void setLegalNightHours(BigDecimal legalNightHours) {
		this.legalNightHours = legalNightHours;
	}

	public BigDecimal getLegalOtHours() {
		return legalOtHours;
	}

	public void setLegalOtHours(BigDecimal legalOtHours) {
		this.legalOtHours = legalOtHours;
	}

	public BigDecimal getSpecialHours() {
		return specialHours;
	}

	public void setSpecialHours(BigDecimal specialHours) {
		this.specialHours = specialHours;
	}

	public BigDecimal getSpecialNightHours() {
		return specialNightHours;
	}

	public void setSpecialNightHours(BigDecimal specialNightHours) {
		this.specialNightHours = specialNightHours;
	}

	public BigDecimal getSpecialOtHours() {
		return specialOtHours;
	}

	public void setSpecialOtHours(BigDecimal specialOtHours) {
		this.specialOtHours = specialOtHours;
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
		builder.append("PayPeriodDTRSummary [id=");
		builder.append(id);
		builder.append(", employeeId=");
		builder.append(employeeId);
		builder.append(", monthYear=");
		builder.append(monthYear);
		builder.append(", payPeriod=");
		builder.append(payPeriod);
		builder.append(", regularHours=");
		builder.append(regularHours);
		builder.append(", nightShiftHours=");
		builder.append(nightShiftHours);
		builder.append(", otHours=");
		builder.append(otHours);
		builder.append(", legalHours=");
		builder.append(legalHours);
		builder.append(", legalNightHours=");
		builder.append(legalNightHours);
		builder.append(", legalOtHours=");
		builder.append(legalOtHours);
		builder.append(", specialHours=");
		builder.append(specialHours);
		builder.append(", specialNightHours=");
		builder.append(specialNightHours);
		builder.append(", specialOtHours=");
		builder.append(specialOtHours);
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
