package com.paystart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paystart.entity.PayrollMain;

@Repository
public interface PayrollMainRepository extends JpaRepository<PayrollMain, Integer> {
	Optional<PayrollMain> findAllByMonthYearAndPayPeriod(String monthYear, String payPeriod);
}
