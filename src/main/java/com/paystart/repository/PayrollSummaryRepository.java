package com.paystart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paystart.entity.PayrollSummary;

public interface PayrollSummaryRepository extends JpaRepository<PayrollSummary, Integer> {

}
