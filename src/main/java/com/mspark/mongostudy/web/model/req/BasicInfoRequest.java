package com.mspark.mongostudy.web.model.req;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString 
@NoArgsConstructor
@ApiModel(parent = CommonProfileRequest.class)
public class BasicInfoRequest extends CommonProfileRequest{
	
	private String name;
	
	private String email;
	
	private String phonenumber;
	
	public BasicInfoRequest(String userid, String name, String email, String phonenumber) {
		super(userid);
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
	}
	
}
