package com.mspark.mongostudy.domain;

import com.mspark.mongostudy.domain.enums.HighSchoolCategory;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter @ToString @EqualsAndHashCode(callSuper = false)
public class HighSchoolScholarship extends AbstractScholarship {

	private HighSchoolCategory category;

	protected HighSchoolScholarship() {
		super();
	}

	@Builder
	protected HighSchoolScholarship(String name, String location, String start, String end, HighSchoolCategory category) {
		super(name, location, start, end);
		this.category = category;
	}
	
}
