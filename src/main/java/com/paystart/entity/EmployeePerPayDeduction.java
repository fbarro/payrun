package com.paystart.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="xin_employee_deduction_per_pay")
public class EmployeePerPayDeduction {
	
	@Id
	@Column(name = "client_deduction_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "hdmf")
	private BigDecimal hdmf;
	
	@Column(name = "arm_bond")
	private BigDecimal armBond;
	
	@Column(name = "cash_bond")
	private BigDecimal cashBond;
	
	@Column(name = "client_id" , insertable = false, updatable = false)
	private Integer clientId;
	
	@Column(name = "created_at")
	private String createdAt;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "updated_at")
	private String updatedAt;
	
	@Column(name = "updated_by")
	private String updatedBy;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

	public EmployeePerPayDeduction() {
		super();
	}

	public EmployeePerPayDeduction(Integer id, BigDecimal hdmf, BigDecimal armBond, BigDecimal cashBond,
			Integer clientId, String createdAt, String createdBy, String updatedAt, String updatedBy, Client client) {
		super();
		this.id = id;
		this.hdmf = hdmf;
		this.armBond = armBond;
		this.cashBond = cashBond;
		this.clientId = clientId;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getHdmf() {
		return hdmf;
	}

	public void setHdmf(BigDecimal hdmf) {
		this.hdmf = hdmf;
	}

	public BigDecimal getArmBond() {
		return armBond;
	}

	public void setArmBond(BigDecimal armBond) {
		this.armBond = armBond;
	}

	public BigDecimal getCashBond() {
		return cashBond;
	}

	public void setCashBond(BigDecimal cashBond) {
		this.cashBond = cashBond;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmployeePerPayDeduction [id=");
		builder.append(id);
		builder.append(", hdmf=");
		builder.append(hdmf);
		builder.append(", armBond=");
		builder.append(armBond);
		builder.append(", cashBond=");
		builder.append(cashBond);
		builder.append(", clientId=");
		builder.append(clientId);
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
