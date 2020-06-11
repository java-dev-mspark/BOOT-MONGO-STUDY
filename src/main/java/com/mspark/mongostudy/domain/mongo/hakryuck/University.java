package com.mspark.mongostudy.domain.mongo.hakryuck;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter @ToString @EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class University extends Scholar {

	private String location;
	private List<String> majors = new ArrayList<>();;
	private int dayTypeValue;
	private int yearTypeValue;
	private double maxGrade;
	private double grede;
	
	@Builder
	public University(String name, String beginningDate, String endDate, int scholarTypeValue,
	                  String location, List<String> majors, int dayTypeValue, int yearTypeValue, double maxGrade, double grede) {
		this.name = name;
		this.beginningDate = beginningDate;
		this.endDate = endDate;
		this.scholarTypeValue = scholarTypeValue;
		this.location = location;
		this.majors = majors;
		this.dayTypeValue = dayTypeValue;
		this.yearTypeValue = yearTypeValue;
		this.maxGrade = maxGrade;
		this.grede = grede;
	}
	
	public void addMajor(String major) {
		if(!majors.contains(major)) {
			majors.add(major);
		}
	}
	
}
