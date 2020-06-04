package com.mspark.mongostudy.web.model.req;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString 
@NoArgsConstructor @AllArgsConstructor
public class BasicInfoRequest extends CommonProfileRequest{
	
	private String name;
	
	private String email;
	
	private String phonenumber;
	
	private MultipartFile image;
}
