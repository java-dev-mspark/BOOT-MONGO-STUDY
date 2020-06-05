package com.mspark.mongostudy.constant;

import lombok.Getter;

@Getter
public enum Code {

	NOERRR(0, "OK");
	
	private int code;
	
	private String message;
		
	Code(int code, String message){
		this.code = code;
		this.message = message;
	}
	
}
