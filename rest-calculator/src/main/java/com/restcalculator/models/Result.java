package com.restcalculator.models;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;

/**
 * Contain the end result/error of the operation
 * @author mohamed.eddaakouri
 */

public class Result {

	private HttpStatus status = HttpStatus.OK;
	private String message = "";
	private Boolean error = Boolean.FALSE;
	private BigDecimal result = null;
	
	//empty constructor
	public Result() {}
	
	public Result(String message, Boolean error, BigDecimal result) {
		super();
		this.message = message;
		this.error = error;
		this.result = result;
	}
	
	public Result(HttpStatus status, String message, Boolean error, BigDecimal result) {
		this(message, error, result);
		this.setStatus(status);
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the error
	 */
	public Boolean getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(Boolean error) {
		this.error = error;
	}
	/**
	 * @return the result
	 */
	public BigDecimal getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(BigDecimal result) {
		this.result = result;
	}
	
	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Result [message=" + message + ", error=" + error + ", result=" + result + "]";
	}
	
}
