package com.mspark.mongostudy.web.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mspark.mongostudy.web.model.resp.CommonResponse;

@RestControllerAdvice
public class CommonExceptionHandler {

	
	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<CommonResponse> handleRuntimeException(RuntimeException e){
		CommonResponse response  = new CommonResponse(500, e.getMessage());
		return new ResponseEntity<CommonResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
