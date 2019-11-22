package com.paystart.service;

import com.paystart.dto.PayrollDetailDTO;
import com.paystart.params.PayrollRunParams;

public interface PayrollRunService {
	PayrollDetailDTO process(PayrollRunParams payrollRunParams);
}
