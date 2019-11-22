package com.paystart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paystart.entity.PayPeriod;

@Repository
public interface PayPeriodRepository extends JpaRepository<PayPeriod, Integer> {
	public Optional<PayPeriod> findNameByCode(String code);
}
