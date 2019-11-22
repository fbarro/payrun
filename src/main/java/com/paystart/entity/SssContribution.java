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
@Table(name = "xin_sss_contribution")
public class SssContribution implements Serializable {
	private static final long serialVersionUID = 8272241147713928776L;

	@Id
	@Column(name = "sss_contribution_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "bracket")
	private Integer bracket;

	@Column(name = "salary_credit")
	private BigDecimal salaryCredit;

	@Column(name = "range_from")
	private BigDecimal rangeFrom;

	@Column(name = "range_to")
	private BigDecimal rangeTo;

	@Column(name = "ee_share")
	private BigDecimal eeShare;

	@Column(name = "er_share")
	private BigDecimal erShare;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Column(name = "updated_by")
	private String updatedBy;

	public SssContribution() {
		super();
	}

	public SssContribution(Integer bracket, BigDecimal salaryCredit, BigDecimal rangeFrom, BigDecimal rangeTo,
			BigDecimal eeShare, BigDecimal erShare, LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt,
			String updatedBy) {
		super();
		this.bracket = bracket;
		this.salaryCredit = salaryCredit;
		this.rangeFrom = rangeFrom;
		this.rangeTo = rangeTo;
		this.eeShare = eeShare;
		this.erShare = erShare;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
	}

	public SssContribution(Integer id, Integer bracket, BigDecimal salaryCredit, BigDecimal rangeFrom,
			BigDecimal rangeTo, BigDecimal eeShare, BigDecimal erShare, LocalDateTime createdAt, String createdBy,
			LocalDateTime updatedAt, String updatedBy) {
		super();
		this.id = id;
		this.bracket = bracket;
		this.salaryCredit = salaryCredit;
		this.rangeFrom = rangeFrom;
		this.rangeTo = rangeTo;
		this.eeShare = eeShare;
		this.erShare = erShare;
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

	public Integer getBracket() {
		return bracket;
	}

	public void setBracket(Integer bracket) {
		this.bracket = bracket;
	}

	public BigDecimal getSalaryCredit() {
		return salaryCredit;
	}

	public void setSalaryCredit(BigDecimal salaryCredit) {
		this.salaryCredit = salaryCredit;
	}

	public BigDecimal getRangeFrom() {
		return rangeFrom;
	}

	public void setRangeFrom(BigDecimal rangeFrom) {
		this.rangeFrom = rangeFrom;
	}

	public BigDecimal getRangeTo() {
		return rangeTo;
	}

	public void setRangeTo(BigDecimal rangeTo) {
		this.rangeTo = rangeTo;
	}

	public BigDecimal getEeShare() {
		return eeShare;
	}

	public void setEeShare(BigDecimal eeShare) {
		this.eeShare = eeShare;
	}

	public BigDecimal getErShare() {
		return erShare;
	}

	public void setErShare(BigDecimal erShare) {
		this.erShare = erShare;
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
		builder.append("SssContribution [id=");
		builder.append(id);
		builder.append(", bracket=");
		builder.append(bracket);
		builder.append(", salaryCredit=");
		builder.append(salaryCredit);
		builder.append(", rangeFrom=");
		builder.append(rangeFrom);
		builder.append(", rangeTo=");
		builder.append(rangeTo);
		builder.append(", eeShare=");
		builder.append(eeShare);
		builder.append(", erShare=");
		builder.append(erShare);
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
