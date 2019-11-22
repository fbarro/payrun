package com.paystart.exceptions.handler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.paystart.exceptions.PayrollPeriodNotFoundException;
import com.paystart.exceptions.response.ErrorResponse;
import com.paystart.exceptions.response.ErrorResponse.ApiErrorResponseBuilder;;


@RestControllerAdvice 
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	public static final Logger LOGGER = LoggerFactory.getLogger(CustomGlobalExceptionHandler.class);

	@ExceptionHandler(value = {Exception.class})
	public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
		return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, ex);
	}
	
	@ExceptionHandler(PayrollPeriodNotFoundException.class)
    public ResponseEntity<ErrorResponse> customHandleNotFound(PayrollPeriodNotFoundException ex) {
		return buildResponseEntity(HttpStatus.NOT_FOUND, ex);
    }
	
	@ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
	protected ResponseEntity<ErrorResponse> handleConflict(RuntimeException ex, WebRequest request) {
		return buildResponseEntity(HttpStatus.CONFLICT, ex);
	}
	
	@ExceptionHandler(value = {IOException.class})
	public final ResponseEntity<ErrorResponse> handleNetwork(IOException ex, WebRequest request) {
		return buildResponseEntity(HttpStatus.PROXY_AUTHENTICATION_REQUIRED, ex);
	}
	
	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<ErrorResponse> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
	    List<String> errors = new ArrayList<String>();
	    for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
	        errors.add(violation.getRootBeanClass().getName() + " " + 
	          violation.getPropertyPath() + ": " + violation.getMessage());
	    }
	    
	    return buildResponseEntity(HttpStatus.BAD_REQUEST, ex);
	}

	private ResponseEntity<ErrorResponse> buildResponseEntity(HttpStatus httpStatus, Exception ex) {
		LOGGER.error(ex.getMessage(), ex);
		
		ApiErrorResponseBuilder builder = new ErrorResponse.ApiErrorResponseBuilder();
		ErrorResponse response = builder.withHttpStatus(httpStatus)
				.withErrorCode(httpStatus.value())
				.withMessage(ex.getMessage())
				.withDateTime(LocalDateTime.now()).build();

		return new ResponseEntity<>(response, response.getHttpStatus());
	}
	
	
}
