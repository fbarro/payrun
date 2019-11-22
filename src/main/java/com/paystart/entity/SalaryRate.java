package com.paystart.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "xin_salary_rate")
public class SalaryRate {

	@Id
	@Column(name = "salary_rate_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "salary_rate_name")
	private String rateName;

	@Column(name = "basic_salary")
	private BigDecimal basicRate;

	@Column(name = "ot_rate")
	private BigDecimal otRate;

	@Column(name = "night_diff_rate")
	private BigDecimal nightDiffRate;

	@Column(name = "legal")
	private BigDecimal legalRate;

	@Column(name = "special")
	private BigDecimal specialRate;

	@Column(name = "created_at")
	private String createdAt;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "updated_at")
	private String updatedAt;

	@Column(name = "updated_by")
	private String updatedBy;

	public SalaryRate(Integer id, String rateName, BigDecimal basicRate, BigDecimal otRate, BigDecimal nightDiffRate,
			BigDecimal legalRate, BigDecimal specialRate, String createdAt, String createdBy, String updatedAt,
			String updatedBy) {
		super();
		this.id = id;
		this.rateName = rateName;
		this.basicRate = basicRate;
		this.otRate = otRate;
		this.nightDiffRate = nightDiffRate;
		this.legalRate = legalRate;
		this.specialRate = specialRate;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
	}

	public SalaryRate() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRateName() {
		return rateName;
	}

	public void setRateName(String rateName) {
		this.rateName = rateName;
	}

	public BigDecimal getBasicRate() {
		return basicRate;
	}

	public void setBasicRate(BigDecimal basicRate) {
		this.basicRate = basicRate;
	}

	public BigDecimal getOtRate() {
		return otRate;
	}

	public void setOtRate(BigDecimal otRate) {
		this.otRate = otRate;
	}

	public BigDecimal getNightDiffRate() {
		return nightDiffRate;
	}

	public void setNightDiffRate(BigDecimal nightDiffRate) {
		this.nightDiffRate = nightDiffRate;
	}

	public BigDecimal getLegalRate() {
		return legalRate;
	}

	public void setLegalRate(BigDecimal legalRate) {
		this.legalRate = legalRate;
	}

	public BigDecimal getSpecialRate() {
		return specialRate;
	}

	public void setSpecialRate(BigDecimal specialRate) {
		this.specialRate = specialRate;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
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
		builder.append("SalaryRate [id=");
		builder.append(id);
		builder.append(", rateName=");
		builder.append(rateName);
		builder.append(", basicRate=");
		builder.append(basicRate);
		builder.append(", otRate=");
		builder.append(otRate);
		builder.append(", nightDiffRate=");
		builder.append(nightDiffRate);
		builder.append(", legalRate=");
		builder.append(legalRate);
		builder.append(", specialRate=");
		builder.append(specialRate);
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
