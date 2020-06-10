package com.mspark.mongostudy.service;

import com.mspark.mongostudy.domain.mongo.basic.BasicInfo;
import com.mspark.mongostudy.web.model.req.BasicInfoRequest;

public interface BasicInfoService {

	public BasicInfo getBasicInfo(String memberid);
	
	public BasicInfo save(BasicInfoRequest request);
}
