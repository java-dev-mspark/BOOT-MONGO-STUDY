package com.mspark.mongostudy.domain.mongo.hakryuck;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter @ToString @EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class HighSchool extends Scholar {
	
	private String location;
	
	private int highSchoolTypeValue;
	
	@Builder
	public HighSchool(String name, String beginningDate, String endDate, int scholarTypeValue, String location, int highSchoolTypeValue) {
		this.name = name;
		this.beginningDate = beginningDate;
		this.endDate = endDate;
		this.scholarTypeValue = scholarTypeValue;
		this.location = location;
		this.highSchoolTypeValue = highSchoolTypeValue;
	}

}
