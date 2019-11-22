package com.paystart.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.paystart.util.ReferencesLookup;

public class PayPeriodValidator implements ConstraintValidator<PayPeriodConstraint, String> {

	@Autowired
	private ReferencesLookup referencesLookup;

	@Override
	public void initialize(PayPeriodConstraint payPeriodConstraint) {
	}

	@Override
	public boolean isValid(String code, ConstraintValidatorContext cxt) {
		return referencesLookup.getPaymentPeriod(code).isPresent();
	}

}