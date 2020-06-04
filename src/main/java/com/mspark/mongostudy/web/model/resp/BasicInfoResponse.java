package com.mspark.mongostudy.web.model.resp;

import com.mspark.mongostudy.domain.BasicInfo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class BasicInfoResponse extends CommonResponse {

	private BasicInfo basicInfo;

	protected BasicInfoResponse() {
		super();
	}

	protected BasicInfoResponse(int code, String message, BasicInfo basicInfo) {
		super(code, message);
		this.basicInfo = basicInfo;
	}
	
}
