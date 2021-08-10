package com.cg.paymentapp.exceptionhandler;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.paymentapp.exception.InvalidInputException;

@ControllerAdvice
public class LoginUserExceptionHandler {
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<?> handleEmployeeDataError(InvalidInputException ex){
		
		Map<String,Object> errors=new LinkedHashMap<>();
		
		errors.put("error","Not a Valid User Credentials");
		errors.put("message", ex.getMessage());
		errors.put("timestamp", LocalDate.now());
		
		return new ResponseEntity<Object>(errors,HttpStatus.NOT_FOUND);

}
}
