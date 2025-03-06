package com.javaexpress.exception;

import java.time.ZonedDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class ExceptionMsg {

	private ZonedDateTime timestamp;
	
	private HttpStatus httpStatus;
	
	private String msg;
	
	private String typeOfMessage;
	
	private Map<String,String> errorsList;

	
	public ExceptionMsg(ZonedDateTime timestamp, HttpStatus httpStatus, String msg, String typeOfMessage) {
		super();
		this.timestamp = timestamp;
		this.httpStatus = httpStatus;
		this.msg = msg;
		this.typeOfMessage = typeOfMessage;
	}

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(ZonedDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTypeOfMessage() {
		return typeOfMessage;
	}

	public void setTypeOfMessage(String typeOfMessage) {
		this.typeOfMessage = typeOfMessage;
	}

	public Map<String, String> getErrorsList() {
		return errorsList;
	}

	public void setErrorsList(Map<String, String> errorsList) {
		this.errorsList = errorsList;
	}
	
	
	
	
}
