package com.javaexpress.exception;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<ExceptionMsg> handleException(Exception ex) {
		var serverError = HttpStatus.INTERNAL_SERVER_ERROR;
		ExceptionMsg result = new ExceptionMsg(ZonedDateTime.now(),serverError,ex.getMessage(),
				"Something went wrong please check the logs more details");
		return new ResponseEntity<>(result,serverError);
	}
	
	@ExceptionHandler(value= {UserNotFoundException.class})
	public ResponseEntity<ExceptionMsg> handleException(UserNotFoundException ex) {
		var serverError = HttpStatus.BAD_REQUEST;
		ExceptionMsg result = new ExceptionMsg(ZonedDateTime.now(),serverError,ex.getMessage(),
				"Validatoin Failed");
		return new ResponseEntity<>(result,serverError);
	}
	
	
	@ExceptionHandler(value= {MethodArgumentNotValidException.class})
	public ResponseEntity<ExceptionMsg> handlException(MethodArgumentNotValidException ex) {
		
		Map<String,String> errros = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			errros.put(fieldName, message);
			
		});
		var badRequest = HttpStatus.BAD_REQUEST;
		ExceptionMsg result = new ExceptionMsg(ZonedDateTime.now(),badRequest,null,
				"Validatoin Failed");
		result.setErrorsList(errros);
		return new ResponseEntity<>(result,badRequest);
	}
	
	
	
	
}
