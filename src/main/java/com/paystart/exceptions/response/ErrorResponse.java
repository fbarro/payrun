package com.paystart.exceptions.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.paystart.model.BaseBean;

public class ErrorResponse extends BaseBean {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private HttpStatus httpStatus;
	private int errorCode;
	private String message;
	private String detail;
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	// Builder
	public static final class ApiErrorResponseBuilder {
		private LocalDateTime timestamp;
		private int errorCode;
		private String message;
		private HttpStatus httpStatus;
		private String detail;
		private String status;

		public ApiErrorResponseBuilder() {
		}

		public ApiErrorResponseBuilder(LocalDateTime timestamp) {
			this.timestamp = timestamp;
		}

		public static ApiErrorResponseBuilder anApiErrorResponse() {
			return new ApiErrorResponseBuilder();
		}
		
		public ApiErrorResponseBuilder withHttpStatus(HttpStatus httpStatus) {
			this.httpStatus = httpStatus;
			return this;
		}

		public ApiErrorResponseBuilder withErrorCode(int errorCode) {
			this.errorCode = errorCode;
			return this;
		}

		public ApiErrorResponseBuilder withMessage(String message) {
			this.message = message;
			return this;
		}

		public ApiErrorResponseBuilder withDetail(String detail) {
			this.detail = detail;
			return this;
		}

		public ApiErrorResponseBuilder withDateTime(LocalDateTime timestamp) {
			this.timestamp = timestamp;
			return this;
		}
		
		public ApiErrorResponseBuilder withStatus(String status) {
			this.status = status;
			return this;
		}

		public ErrorResponse build() {
			ErrorResponse apiErrorResponse = new ErrorResponse();
			apiErrorResponse.setHttpStatus(this.httpStatus);
			apiErrorResponse.setErrorCode(this.errorCode);
			apiErrorResponse.setDetail(this.detail);
			apiErrorResponse.setMessage(this.message);
			apiErrorResponse.setTimestamp(timestamp);
			
			if(this.status != null) apiErrorResponse.setStatus(this.status);
			
			return apiErrorResponse;
		}
	}
}
