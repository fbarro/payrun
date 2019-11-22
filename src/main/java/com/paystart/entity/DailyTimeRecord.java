package com.paystart.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="xin_attendance_time")
public class DailyTimeRecord {
	
	@Id
	@Column(name = "time_attendance_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "employee_id")
	private Integer employeeId;
	
	@Column(name = "attendance_date")
	private String attendanceDate;
	
	@Column(name = "total_work")
	private BigDecimal workHour;
	
	@Column(name = "overtime")
	private BigDecimal overtime;
	
	@Column(name = "night_diff")
	private BigDecimal nightDiff;
	
	@Column(name = "time_remarks_code")
	private String remarks;
	
	@Column(name = "create_at")
	private String createdAt;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "updated_at")
	private String updatedAt;
	
	public DailyTimeRecord() {
		super();
	}

	public DailyTimeRecord(Integer employeeId, String attendanceDate, BigDecimal workHour, BigDecimal overtime, BigDecimal nightDiff,
			String remarks, String createdAt, String createdBy, String updatedAt, String updatedBy) {
		super();
		this.employeeId = employeeId;
		this.attendanceDate = attendanceDate;
		this.workHour = workHour;
		this.overtime = overtime;
		this.nightDiff = nightDiff;
		this.remarks = remarks;
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

	public String getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(String attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	public BigDecimal getWorkHour() {
		return workHour;
	}

	public void setWorkHour(BigDecimal workHour) {
		this.workHour = workHour;
	}

	public BigDecimal getOvertime() {
		return overtime;
	}

	public void setOvertime(BigDecimal overtime) {
		this.overtime = overtime;
	}

	public BigDecimal getNightDiff() {
		return nightDiff;
	}

	public void setNightDiff(BigDecimal nightDiff) {
		this.nightDiff = nightDiff;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	@Column(name = "updated_by")
	private String updatedBy;
	
	
}
