package com.best.practice.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.best.practice.exceptions.CustomException;
import com.best.practice.exceptions.ErrorResponse;
import com.best.practice.exceptions.RecordNotFoundException;

@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(CustomException.class)
	  public final ResponseEntity<Object> handleAllExceptions(CustomException ex) {
		List<String> details = new ArrayList<>();
	    details.add(ex.getLocalizedMessage());
	    ErrorResponse error = new ErrorResponse(ex.getMessage(), details);
	    return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	
	@ExceptionHandler(Exception.class)
	  public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
	    List<String> details = new ArrayList<>();
	    details.add(ex.getLocalizedMessage());
	    ErrorResponse error = new ErrorResponse("Server Error", details);
	    return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	 
	  @ExceptionHandler(RecordNotFoundException.class)
	  public final ResponseEntity<Object> handleUserNotFoundException(RecordNotFoundException ex, WebRequest request) {
	    List<String> details = new ArrayList<>();
	    details.add(ex.getLocalizedMessage());
	    ErrorResponse error = new ErrorResponse("Record Not Found", details);
	    return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	  }
	 
	  @Override
	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	    List<String> details = new ArrayList<>();
	    for(ObjectError error : ex.getBindingResult().getAllErrors()) {
	      details.add(error.getDefaultMessage());
	    }
	    ErrorResponse error = new ErrorResponse("Validation Failed", details);
	    return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	  }

}
