package com.mspark.mongostudy.domain;

import com.mspark.mongostudy.domain.enums.UniversityCategory;

import lombok.Getter;

@Getter
public class UniversityScholarship extends AbstractScholarship {
	
	private UniversityCategory category;
	
	private double maxGrade;
	
	private double myGrade;
	
}
