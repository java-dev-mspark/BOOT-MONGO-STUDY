package com.mspark.mongostudy.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mspark.mongostudy.service.BasicInfoService;
import com.mspark.mongostudy.web.model.resp.BasicInfoResponse;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
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
	public BasicInfoResponse getBasicInfo(@PathVariable(name = "memberid", required = true) String id) {
		basicInfoService.getBasicInfo(id);
		return null;
	}
	
}
