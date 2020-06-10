package com.mspark.mongostudy.web.model.resp;

import com.mspark.mongostudy.domain.mongo.basic.BasicInfo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BasicInfoResponse extends CommonResponse {

	private BasicInfo basicInfo;

	@Builder
	public BasicInfoResponse(int code, String message, BasicInfo basicInfo) {
		super(code, message);
		this.basicInfo = basicInfo;
	}
	
}
