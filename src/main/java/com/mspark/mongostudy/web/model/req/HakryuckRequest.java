package com.mspark.mongostudy.web.model.req;

import java.util.List;

import com.mspark.mongostudy.domain.mongo.hakryuck.HighSchool;
import com.mspark.mongostudy.domain.mongo.hakryuck.University;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class HakryuckRequest extends CommonProfileRequest {

	private HighSchool highSchool;
	
	private List<University> universities;

	public HakryuckRequest(String userid, HighSchool highSchool, List<University> universities) {
		super(userid);
		this.highSchool = highSchool;
		this.universities = universities;
	}
	
}
