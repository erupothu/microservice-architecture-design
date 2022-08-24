package com.best.practice.exceptions;

public class CustomException extends RuntimeException {

	private String message;
	private String details;
	private String hint;
	private String error;
	private String support;
	
	public CustomException(String message, String details, String hint, String error, String support) {
		super();
		this.message = message;
		this.details = details;
		this.hint = hint;
		this.error = error;
		this.support = support;
	}
	public CustomException(String message, String error) {
		super();
		this.message = message;
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getSupport() {
		return support;
	}
	public void setSupport(String support) {
		this.support = support;
	}
	
}
