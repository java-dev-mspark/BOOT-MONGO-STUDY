package com.mspark.mongostudy.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mspark.mongostudy.constant.Code;
import com.mspark.mongostudy.domain.mongo.basic.BasicInfo;
import com.mspark.mongostudy.service.BasicInfoService;
import com.mspark.mongostudy.web.model.req.BasicInfoRequest;
import com.mspark.mongostudy.web.model.resp.BasicInfoResponse;
import com.mspark.mongostudy.web.model.resp.CommonResponse;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class BasicInfoController {
	
	private final BasicInfoService basicInfoService;

	@ApiOperation(value ="Get Basic Information by memberid")
	@ApiImplicitParams({
		@ApiImplicitParam(name ="memberid",
						  value="멤버의 고유 아이디", 
						  required = true,
						  dataType = "String",
						  paramType = "path",
						  defaultValue = "")
	})
	@GetMapping("/basicinfo/{memberid}")
	public BasicInfoResponse getBasicInfo(@PathVariable(name = "memberid", required = true) String memberid) {
		log.trace("Call getBasicInfo()");
		log.debug("Param : [memberid : {}]", memberid);
		BasicInfo basicInfo = basicInfoService.getBasicInfo(memberid);
		
		log.debug("BasicInfo : {}", basicInfo);
		
		return BasicInfoResponse.builder()
								.code(Code.NOERRR.getCode())
								.message(Code.NOERRR.getMessage())
								.basicInfo(basicInfo)
								.build();
	}


	@ApiOperation(value = "Save Basic Information")
	@PostMapping("/basicinfo/save")
	public CommonResponse saveBasicInfo(@RequestBody(required = true) BasicInfoRequest request) {
		log.trace("Call saveBasicInfo()");
		log.debug("Param : [BasicInfoRequest : {}]", request);
		
		basicInfoService.save(request);
		
		return new CommonResponse(Code.NOERRR.getCode(), Code.NOERRR.getMessage());
	}
}
