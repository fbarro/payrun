package com.paystart.service;

import java.util.concurrent.Callable;

import com.paystart.model.Result;

public interface PayrollCalculation extends Callable<Result> {
}
