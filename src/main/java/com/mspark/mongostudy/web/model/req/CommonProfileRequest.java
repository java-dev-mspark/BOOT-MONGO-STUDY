package com.mspark.mongostudy.web.model.req;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel(subTypes = {BasicInfoRequest.class}, discriminator = "userid" ,description = "userid")
@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommonProfileRequest {

	private String userid;
}
