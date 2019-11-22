package com.paystart.entity;

import javax.persistence.CascadeType;
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
@Table(name = "xin_clients")
public class Client {

	@Id
	@Column(name = "client_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "salary_rate_id", insertable = false, updatable = false)
	private Integer salaryRateId;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "is_active")
	private Integer isActive;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "salary_rate_id", referencedColumnName = "salary_rate_id", unique = true)
	private SalaryRate salaryRate;
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "client")
	private EmployeePerPayDeduction employeePerPayDeduction;

	public Client() {
		super();
	}

	public Client(Integer id, String name, Integer salaryRateId, String companyName, Integer isActive,
			SalaryRate salaryRate, EmployeePerPayDeduction employeePerPayDeduction) {
		super();
		this.id = id;
		this.name = name;
		this.salaryRateId = salaryRateId;
		this.companyName = companyName;
		this.isActive = isActive;
		this.salaryRate = salaryRate;
		this.employeePerPayDeduction = employeePerPayDeduction;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalaryRateId() {
		return salaryRateId;
	}

	public void setSalaryRateId(Integer salaryRateId) {
		this.salaryRateId = salaryRateId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public SalaryRate getSalaryRate() {
		return salaryRate;
	}

	public void setSalaryRate(SalaryRate salaryRate) {
		this.salaryRate = salaryRate;
	}

	public EmployeePerPayDeduction getEmployeePerPayDeduction() {
		return employeePerPayDeduction;
	}

	public void setEmployeePerPayDeduction(EmployeePerPayDeduction employeePerPayDeduction) {
		this.employeePerPayDeduction = employeePerPayDeduction;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Client [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", salaryRateId=");
		builder.append(salaryRateId);
		builder.append(", companyName=");
		builder.append(companyName);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append(", salaryRate=");
		builder.append(salaryRate);
		builder.append(", employeePerPayDeduction=");
		builder.append(employeePerPayDeduction);
		builder.append("]");
		return builder.toString();
	}

}
