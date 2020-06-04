package com.mspark.mongostudy.service;

import com.mspark.mongostudy.domain.BasicInfo;
import com.mspark.mongostudy.web.model.req.BasicInfoRequest;

public interface BasicInfoService {

	public BasicInfo getBasicInfo(String id);
	
	public BasicInfo save(BasicInfoRequest request);
}
