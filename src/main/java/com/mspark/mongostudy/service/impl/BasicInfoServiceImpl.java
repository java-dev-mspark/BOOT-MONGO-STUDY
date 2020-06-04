package com.mspark.mongostudy.service.impl;

import java.io.IOException;
import java.util.Optional;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
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
	public BasicInfo getBasicInfo(String userid) {
		Assert.notNull(userid, "The userid param is required");
		Assert.hasLength(userid, "The userid param must not empty");
		
		Optional<BasicInfo> basicInfo = basicInfoRepository.findById(userid);
		
		return basicInfo.orElseThrow(() -> new IllegalStateException("No Data"));
	}

	@Override
	public BasicInfo save(BasicInfoRequest request) {
		Assert.notNull(request, "The request param is required");
	
		Optional<BasicInfo> optionalBasicInfo = basicInfoRepository.findById(request.getUserid());
		BasicInfo basicInfo = null;
		try {
			basicInfo = optionalBasicInfo.orElse(BasicInfo
													.builder()
													.id(request.getUserid())
													.name(request.getName())
													.email(request.getEmail())
													.phonenumber(request.getPhonenumber())
													.image(new Binary(BsonBinarySubType.BINARY, request.getImage().getBytes()))
													.build());
			
			if(optionalBasicInfo.isPresent()) {
				basicInfo.update(request);
			}
		}
		catch (IOException e) {
			throw new IllegalStateException(e);
		}
		
		return basicInfoRepository.save(basicInfo);
	}
	
}
