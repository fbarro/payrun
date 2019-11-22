package com.paystart.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paystart.constants.AppMessages;
import com.paystart.constants.PayrollStatus;
import com.paystart.dto.PayrollDetailDTO;
import com.paystart.entity.Employee;
import com.paystart.entity.PayPeriod;
import com.paystart.entity.PayrollMain;
import com.paystart.exceptions.PayrollExistsException;
import com.paystart.exceptions.PayrollPeriodNotFoundException;
import com.paystart.model.Result;
import com.paystart.params.PayrollRunParams;
import com.paystart.repository.EmployeeRepository;
import com.paystart.repository.PayrollMainRepository;
import com.paystart.service.PayrollRunService;
import com.paystart.util.ReferencesLookup;

@Service
@Transactional
public class PayrollRunServiceImpl implements PayrollRunService {
	
	private final EmployeeRepository employeeRepository;
	private final PayrollMainRepository payrollMainRepository;
	private final ReferencesLookup referencesLookup;
	private final PayrollCalculationTask payrollCalculationTask;
	
	@Autowired
	public PayrollRunServiceImpl(EmployeeRepository employeeRepository, PayrollMainRepository payrollMainRepository,
			 ReferencesLookup referencesLookup, PayrollCalculationTask payrollCalculationTask) {
		this.employeeRepository = employeeRepository;
		this.payrollMainRepository = payrollMainRepository;
		this.referencesLookup = referencesLookup;
		this.payrollCalculationTask = payrollCalculationTask;
	}

	public PayrollDetailDTO process(PayrollRunParams payrollRunParams) {
		List<Result> processed = new ArrayList<Result>();
		List<Result> unprocessed = new ArrayList<Result>();
		
		Optional<PayrollMain> payrollMainOpt =	payrollMainRepository.findAllByMonthYearAndPayPeriod(
				payrollRunParams.getMonthYear(), payrollRunParams.getPayPeriod());
		
		if(payrollMainOpt.isPresent()) {
			PayrollMain payrollMain = payrollMainOpt.get();
			if(PayrollStatus.FINAL.name().equals(payrollMain.getStatus())){
				throw new PayrollExistsException(AppMessages.PAYROLL_IS_FINALIZED.getMessage());
			}
			
			System.out.println("Not yet final" +payrollMain+". Reprocess payroll." +payrollRunParams);
		} else {
			payrollMainRepository.save(new PayrollMain(payrollRunParams.getMonthYear(), payrollRunParams.getPayPeriod()
					, PayrollStatus.INCOMPLETE.name(), LocalDateTime.now(), "del", LocalDateTime.now(), "del"));
		}
		
		Optional<List<Employee>> employees = employeeRepository.findAllByIsActive(1);
		if(!employees.isPresent()) {
			System.out.println("No Active Employee");
			
			return new PayrollDetailDTO(payrollRunParams, processed.size(), unprocessed.size()
					, AppMessages.NO_ACTIVE_EMPLOYEE.getMessage(), LocalDateTime.now());
		}
		
		Optional<PayPeriod> payPeriodOpt = referencesLookup.getPaymentPeriod(payrollRunParams.getPayPeriod());
		if(!payPeriodOpt.isPresent()) {
			System.out.println("Pay period look up does not exist");
			
			throw new PayrollPeriodNotFoundException(AppMessages.PAYPERIOD_DOES_NOT_EXIST.getMessage());
		}
		
		String payPeriodFrom = payPeriodOpt.map(PayPeriod::getPayFrom).get();
		String payPeriodTo = payPeriodOpt.map(PayPeriod::getPayTo).get();
		
		//Set attendance parameters
		payrollRunParams.setAttendanceFrom(payPeriodFrom);
		payrollRunParams.setAttendanceTo(payPeriodTo);
		
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		for(Employee employee : employees.get()) {
			System.out.println("loop: " + employee);
			
			
			Callable<Result> task = getPayrollCalculationTask(employee, payrollRunParams);
			
			Future<Result> future = executor.submit(task);
			
			try {
				Result calculationResult = future.get();
				System.out.println(calculationResult);
				processed.add(calculationResult);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				unprocessed.add(new Result(employee, e.getMessage()));
			}
		}
		
		executor.shutdown();

		return new PayrollDetailDTO(payrollRunParams, processed.size(), unprocessed.size()
				, AppMessages.PROCESSED_EMPLOYEE_COMPLETE.getMessage(), LocalDateTime.now());
	}
	
	private PayrollCalculationTask getPayrollCalculationTask(Employee employee, PayrollRunParams payrollRunParams) {
		payrollCalculationTask.setEmployee(employee);
		payrollCalculationTask.setPayrollRunParams(payrollRunParams);
		return payrollCalculationTask;
	}
		

}
