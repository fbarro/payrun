package com.paystart.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.paystart.entity.SssContribution;

public interface SssContributionRepository extends JpaRepository<SssContribution, Integer> {
	Optional<SssContribution> findByBracket(Integer bracket);
	
	@Query(value = "SELECT sss FROM SssContribution sss WHERE range_from <= :amount "
			+ "AND range_to >= :amount ")
	public Optional<SssContribution> findSSSBetweenRange(@Param("amount") BigDecimal amount);
}
