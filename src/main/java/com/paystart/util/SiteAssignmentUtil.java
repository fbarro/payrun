package com.paystart.util;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.paystart.constants.AppConstant;
import com.paystart.entity.Client;
import com.paystart.entity.SalaryRate;

@Component
public class SiteAssignmentUtil {
	private Optional<Client> client;
	
	public SiteAssignmentUtil(Optional<Client> client) {
		this.client = client;
	}

	public BigDecimal getBasicRate() {
		return client.map(Client::getSalaryRate).map(SalaryRate::getBasicRate).orElse(BigDecimal.ZERO);
	}
	
	public BigDecimal getBasicRatePerhour() {
		return getBasicRate().divide(AppConstant.HOURS_PER_DAY);
	}

	public BigDecimal getOtRate() {
		return client.map(Client::getSalaryRate).map(SalaryRate::getOtRate).orElse(BigDecimal.ZERO);
	}
	
	public BigDecimal getOTRatePerhour(BigDecimal basicRatePerHour) {
		if(basicRatePerHour == null) {
			basicRatePerHour = new BigDecimal(0);
		}
		
		BigDecimal multiplier = this.getOtRate().divide(AppConstant.DIV_100);
		return basicRatePerHour.multiply(multiplier);
	}
	
	public BigDecimal getNightDiffRate() {
		return client.map(Client::getSalaryRate).map(SalaryRate::getNightDiffRate).orElse(BigDecimal.ZERO);
	}
	
	public BigDecimal getNightDiffRatePerHour(BigDecimal basicRatePerHour) {
		if(basicRatePerHour == null) {
			basicRatePerHour = new BigDecimal(0);
		}
		
		BigDecimal multiplier = this.getNightDiffRate().divide(AppConstant.DIV_100);
		return basicRatePerHour.multiply(multiplier);
	}

	public BigDecimal getLegalRate() {
		return client.map(Client::getSalaryRate).map(SalaryRate::getLegalRate).orElse(BigDecimal.ZERO);
	}
	
	public BigDecimal getLegalRatePerHour(BigDecimal basicRatePerHour) {
		if(basicRatePerHour == null) {
			basicRatePerHour = new BigDecimal(0);
		}
		
		return basicRatePerHour.multiply(this.getLegalRate());
	}
	
	public BigDecimal getSpecialRate() {
		return client.map(Client::getSalaryRate).map(SalaryRate::getSpecialRate).orElse(BigDecimal.ZERO);
	}
	
	public BigDecimal getSpecialRatePerHour(BigDecimal basicRatePerHour) {
		if(basicRatePerHour == null) {
			basicRatePerHour = new BigDecimal(0);
		}
		
		return basicRatePerHour.multiply(this.getSpecialRate());
	}
	
}
