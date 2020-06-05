package com.mspark.mongostudy.web.model.resp;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommonResponse {

	private int code;
	
	private String message;
	
	public CommonResponse(int code, String message) {
		this.code = code;
		this.message = message;
	}
}
