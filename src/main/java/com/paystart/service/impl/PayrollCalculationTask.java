package com.paystart.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.paystart.constants.AppMessages;
import com.paystart.constants.AttendanceRemark;
import com.paystart.entity.Client;
import com.paystart.entity.DailyTimeRecord;
import com.paystart.entity.Employee;
import com.paystart.entity.PayrollSummary;
import com.paystart.entity.SssContribution;
import com.paystart.exceptions.PayrollServiceException;
import com.paystart.model.Result;
import com.paystart.params.PayrollRunParams;
import com.paystart.repository.ClientRepository;
import com.paystart.repository.DateTimeRecordRepository;
import com.paystart.repository.PayrollSummaryRepository;
import com.paystart.repository.SssContributionRepository;
import com.paystart.service.PayrollCalculation;
import com.paystart.util.SiteAssignmentUtil;

@Service
public class PayrollCalculationTask implements PayrollCalculation {
	private PayrollRunParams payrollRunParams;
	private Employee employee;
	
	private final DateTimeRecordRepository dateTimeRecordRepository;
	private final ClientRepository clientRepository;
	private final SssContributionRepository sssContributionRepository;
	private final PayrollSummaryRepository payrollSummaryRepository;
	
	public PayrollCalculationTask(DateTimeRecordRepository dateTimeRecordRepository, ClientRepository clientRepository,
			SssContributionRepository sssContributionRepository, PayrollSummaryRepository payrollSummaryRepository) {
		super();
		this.dateTimeRecordRepository = dateTimeRecordRepository;
		this.clientRepository = clientRepository;
		this.sssContributionRepository = sssContributionRepository;
		this.payrollSummaryRepository = payrollSummaryRepository;
	}

	@Override
	public Result call() throws PayrollServiceException {
		System.out.println("Thread name in PayrollCalculation: " + Thread.currentThread().getName());
		System.out.println("PayrollRunParams: "+payrollRunParams);
		System.out.println("Employee: "+employee);
		
		setSSS();
		return processPayroll();
	}

	public Result processPayroll() {
		List<DailyTimeRecord> dtrs = dateTimeRecordRepository.findDTRByEmployeeIdAndAttendanceDate(employee.getId()
				, payrollRunParams.getAttendanceFrom(), payrollRunParams.getAttendanceTo());
		
		if(dtrs.size()==0) {
			return new Result(employee, AppMessages.PROCESSED_EMPLOYEE_NO_DTR.getMessage());
		}
		
		Optional<Client> siteAssigment = clientRepository.findById(2);
		if(!siteAssigment.isPresent()) {
			return new Result(employee, AppMessages.PROCESSED_EMPLOYEE_NO_DTR.getMessage());
		}
		
		SiteAssignmentUtil siteAssignmentUtil = new SiteAssignmentUtil(siteAssigment);
		
		//REGULAR Rates
//		BigDecimal basicRate = siteAssignmentUtil.getBasicRate();
		BigDecimal basicRatePerHour = siteAssignmentUtil.getBasicRatePerhour();
		BigDecimal otRatePerHour = siteAssignmentUtil.getOTRatePerhour(basicRatePerHour);
		BigDecimal nightDiffRatePerHour = siteAssignmentUtil.getNightDiffRatePerHour(basicRatePerHour);
		
		// LEGAL Holiday Rates
		BigDecimal legalRatePerHour = siteAssignmentUtil.getLegalRatePerHour(basicRatePerHour);
		BigDecimal legalOTRatePerHour = siteAssignmentUtil.getOTRatePerhour(legalRatePerHour);
		BigDecimal legalNightShiftRatePerHour = siteAssignmentUtil.getNightDiffRatePerHour(legalRatePerHour);
		
		//SPECIAL Holiday Rates
		BigDecimal specialRatePerHour = siteAssignmentUtil.getSpecialRatePerHour(basicRatePerHour);
		BigDecimal specialOTRatePerHour = siteAssignmentUtil.getNightDiffRatePerHour(specialRatePerHour);
		BigDecimal specialNightShiftRatePerHour = siteAssignmentUtil.getNightDiffRatePerHour(specialRatePerHour);
		
		
		///TIME variables
		BigDecimal regularHours = new BigDecimal(0); 
		BigDecimal nightShiftHours = new BigDecimal(0);
		BigDecimal overtimeHours = new BigDecimal(0);
		
		BigDecimal legalHours = new BigDecimal(0); 
		BigDecimal legalNightShiftHours = new BigDecimal(0); 
		BigDecimal legalOTHours = new BigDecimal(0); 
		
		BigDecimal specialHours = new BigDecimal(0); 
		BigDecimal specialNightShiftHours = new BigDecimal(0); 
		BigDecimal specialOTHours = new BigDecimal(0); 
		
		for(DailyTimeRecord dtr : dtrs) {
			if(AttendanceRemark.PRESENT.name().equals(dtr.getRemarks())){
				regularHours = regularHours.add(dtr.getWorkHour());
				nightShiftHours = nightShiftHours.add(dtr.getNightDiff());
				overtimeHours = overtimeHours.add(dtr.getOvertime());
			}

			if(AttendanceRemark.LEGAL.name().equals(dtr.getRemarks())){
				legalHours = legalHours.add(dtr.getWorkHour());
				legalNightShiftHours = legalNightShiftHours.add(dtr.getNightDiff());
				legalOTHours = legalOTHours.add(dtr.getOvertime());
			}
			
			if(AttendanceRemark.SPECIAL.name().equals(dtr.getRemarks())){
				specialHours = specialHours.add(dtr.getWorkHour());
				specialNightShiftHours = specialNightShiftHours.add(dtr.getNightDiff());
				specialOTHours = specialOTHours.add(dtr.getOvertime());
			}
		}
		
		
		//compute REGULAR pay
		BigDecimal regularPay = regularHours.multiply(basicRatePerHour);
		BigDecimal nightShiftPay = nightShiftHours.multiply(nightDiffRatePerHour);
		BigDecimal otPay = overtimeHours.multiply(otRatePerHour);
		
		//compute LEGAL pay
		BigDecimal legalPay = legalHours.multiply(legalRatePerHour);
		BigDecimal legalNightShiftPay = legalNightShiftHours.multiply(legalNightShiftRatePerHour);
		BigDecimal legalOtPay = legalOTHours.multiply(legalOTRatePerHour);
		
		//compute SPECIAL pay
		BigDecimal specialPay = specialHours.multiply(specialRatePerHour);
		BigDecimal specialNightShiftPay = specialNightShiftHours.multiply(specialNightShiftRatePerHour);
		BigDecimal specialOTPay = specialOTHours.multiply(specialOTRatePerHour);
		
		//SUB-TOTAL
		BigDecimal basicPayTotal = regularPay.add(legalPay).add(specialPay);
		BigDecimal nightShiftPayTotal = nightShiftPay.add(legalNightShiftPay).add(specialNightShiftPay);
		BigDecimal otPayTotal = otPay.add(legalOtPay).add(specialOTPay);

		BigDecimal grossPayTotal = new BigDecimal(0).add(basicPayTotal).add(nightShiftPayTotal).add(otPayTotal);
		
		PayrollSummary payrollSummary = new PayrollSummary(employee.getId(), payrollRunParams.getMonthYear(), payrollRunParams.getPayPeriod()
				, basicPayTotal, nightShiftPayTotal, otPayTotal, grossPayTotal, LocalDateTime.now(), payrollRunParams.getUserId(),
				LocalDateTime.now(), payrollRunParams.getUserId());
		
		
		PayrollSummary payrollNew = payrollSummaryRepository.saveAndFlush(payrollSummary);

		// DEDUCTIONS
		Optional<SssContribution> co = sssContributionRepository.findSSSBetweenRange(grossPayTotal);
	//	double sssContribution = sssTableLookup(basicPayTotal);
		
		
		
		return new Result(employee, AppMessages.PROCESSED_EMPLOYEE.getMessage());
	}

	public PayrollRunParams getPayrollRunParams() {
		return payrollRunParams;
	}

	public void setPayrollRunParams(PayrollRunParams payrollRunParams) {
		this.payrollRunParams = payrollRunParams;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	private void setSSS() {
		double start = 2000;
		double end = 20000;
		int ctr = 1;
		BigDecimal rangeFrom = new BigDecimal(1);
		rangeFrom = rangeFrom.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		
		BigDecimal rangeTO = new BigDecimal(2250);
		rangeTO = rangeTO.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		
		BigDecimal eeShare = new BigDecimal(80);
		eeShare = eeShare.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		
		BigDecimal erShare = new BigDecimal(160);
		erShare = erShare.setScale(2, BigDecimal.ROUND_HALF_EVEN);

		for(double x=start;x<=end;x+=500) {
			int id = ctr++;
			
			Optional<SssContribution> sOpt = sssContributionRepository.findByBracket(id);
			
			SssContribution s = null;
			if(!sOpt.isPresent()) {
					s = new SssContribution(id,  new BigDecimal(x), rangeFrom, 
							rangeTO, eeShare, erShare, LocalDateTime.now(), "fbarro",
								LocalDateTime.now(), "fbarro");
			} else {
				s = sOpt.get();
				s.setSalaryCredit(new BigDecimal(x));
				s.setRangeFrom(rangeFrom);
				s.setRangeTo(rangeTO);
				s.setEeShare(eeShare);
				s.setErShare(erShare);
				s.setUpdatedAt(LocalDateTime.now());
			}
			
			sssContributionRepository.save(s);
			
			if(id==1) {
				rangeFrom = rangeTO;
				rangeTO = rangeTO.add(new BigDecimal(499.99));
			} else {
				rangeFrom = rangeTO.add(new BigDecimal(0.01));
				rangeTO = rangeTO.add(new BigDecimal(500));
			}
			
			
			
			eeShare = eeShare.add(new BigDecimal(20));
			erShare = erShare.add(new BigDecimal(40));
		}
	}
	
}
