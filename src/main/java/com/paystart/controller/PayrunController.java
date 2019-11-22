package com.paystart.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paystart.constraint.PayPeriodConstraint;
import com.paystart.dto.PayrollDetailDTO;
import com.paystart.params.PayrollRunParams;
import com.paystart.service.PayrollRunService;


@RestController
@Validated
public class PayrunController {

	private final PayrollRunService payrollRunService;
	
	@Autowired
	public PayrunController(PayrollRunService payrollRunService) {
		this.payrollRunService = payrollRunService;
	}

	@GetMapping("/payroll")
	public ResponseEntity<PayrollDetailDTO> payrollProcess(@RequestParam(value = "monthYear") @NotNull String monthYear,
			@RequestParam(value = "payPeriod") @NotNull @PayPeriodConstraint String payPeriod,
			@RequestParam(value = "employeeId") String employeeId,
			@RequestParam(value = "userId") String userId) {
		
		PayrollRunParams params = new PayrollRunParams(monthYear, payPeriod, employeeId, userId);
		
		return ResponseEntity.ok(payrollRunService.process(params));
	}

}
