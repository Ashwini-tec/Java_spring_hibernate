package com.ak47.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ak47.pojo.ResponseDataPojo;

@RestControllerAdvice
public class GlobalExceptionHandeler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ResponseDataPojo> responseNotFoundExceptionHandler(ResourceNotFoundException ex ){
		String message = ex.getMessage();
		ResponseDataPojo response = new ResponseDataPojo(message, false);
		return new ResponseEntity<ResponseDataPojo>(response, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex ){
		Map<String, String> res = new HashMap<>();
		
		
		ex.getBindingResult().getAllErrors().forEach((error)-> {
			String fieldName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			res.put(fieldName, message);
		});
		
		return new ResponseEntity<Map<String, String>>(res, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(ResourceAlreadyExistException.class)
	public ResponseEntity<ResponseDataPojo> responseNotFoundExceptionHandler(ResourceAlreadyExistException ex ){
		String message = ex.getMessage();
		ResponseDataPojo response = new ResponseDataPojo(message, false);
		return new ResponseEntity<ResponseDataPojo>(response, HttpStatus.CONFLICT);
		
	}

}
