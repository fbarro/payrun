package com.paystart.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paystart.entity.PayPeriod;
import com.paystart.repository.PayPeriodRepository;

@Component
public class ReferencesLookup {
	private final PayPeriodRepository payPeriodRepository;

	@Autowired
	public ReferencesLookup(PayPeriodRepository payPeriodRepository) {
		super();
		this.payPeriodRepository = payPeriodRepository;
	}
	
	public Optional<PayPeriod> getPaymentPeriod(String code) { 
		return payPeriodRepository.findNameByCode(code);
	}
	
}
