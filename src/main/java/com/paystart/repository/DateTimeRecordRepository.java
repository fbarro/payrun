package com.paystart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.paystart.entity.DailyTimeRecord;

@Repository
public interface DateTimeRecordRepository  extends JpaRepository<DailyTimeRecord, Integer> {
	
	@Query(value = "SELECT dtr FROM DailyTimeRecord dtr WHERE employeeId = :employeeId "
			+ "AND attendanceDate BETWEEN cast(:attendanceDateFrom AS date) AND cast(:attendanceDateTo AS date) ")
	public List<DailyTimeRecord> findDTRByEmployeeIdAndAttendanceDate(@Param("employeeId") Integer employeeId,
			@Param("attendanceDateFrom") String attendanceDateFrom, @Param("attendanceDateTo") String attendanceDateTo);
}
