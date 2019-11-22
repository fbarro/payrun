package com.paystart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "xin_pay_period")
public class PayPeriod {

	@Id
	@Column(name = "pay_period_id")
	private Integer id;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "pay_from")
	private String payFrom;

	@Column(name = "pay_to")
	private String payTo;

	@Column(name = "status")
	private String status;

	public PayPeriod() {
		super();
	}

	public PayPeriod(Integer id, String code, String name, String payFrom, String payTo, String status) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.payFrom = payFrom;
		this.payTo = payTo;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPayFrom() {
		return payFrom;
	}

	public void setPayFrom(String payFrom) {
		this.payFrom = payFrom;
	}

	public String getPayTo() {
		return payTo;
	}

	public void setPayTo(String payTo) {
		this.payTo = payTo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PayPeriod [id=");
		builder.append(id);
		builder.append(", code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append(", payFrom=");
		builder.append(payFrom);
		builder.append(", payTo=");
		builder.append(payTo);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
}
