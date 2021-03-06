package com.mspark.mongostudy.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.mspark.mongostudy.domain.BasicInfo;
import com.mspark.mongostudy.repository.BasicInfoRepository;
import com.mspark.mongostudy.service.BasicInfoService;
import com.mspark.mongostudy.web.model.req.BasicInfoRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BasicInfoServiceImpl implements BasicInfoService {

	private final BasicInfoRepository basicInfoRepository;
	
	@Override
	public BasicInfo getBasicInfo(String memberid) {
		Assert.notNull(memberid, "The memberid param is required");
		Assert.hasLength(memberid, "The memberid param must not empty");
		
		Optional<BasicInfo> basicInfo = basicInfoRepository.findById(memberid);
		
		return basicInfo.orElseThrow(() -> new IllegalStateException("No Data"));
	}

	@Override
	public BasicInfo save(BasicInfoRequest request) {
		Assert.notNull(request, "The request param is required");
	
		Optional<BasicInfo> optionalBasicInfo = basicInfoRepository.findById(request.getUserid());
		BasicInfo basicInfo 
			= optionalBasicInfo.orElse(BasicInfo
										.builder()
										.id(request.getUserid())
										.name(request.getName())
										.email(request.getEmail())
										.phonenumber(request.getPhonenumber())
										.build());
		
		if(optionalBasicInfo.isPresent()) {
			basicInfo.update(request);
		}
		return basicInfoRepository.save(basicInfo);
	}
	
}
