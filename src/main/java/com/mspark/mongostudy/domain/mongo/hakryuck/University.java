package com.mspark.mongostudy.domain.mongo.hakryuck;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class University extends Scholar {

	private List<String> majors = new ArrayList<>();;
	private int dayTypeValue;
	private int yearTypeValue;
	private double maxGrade;
	private double grede;
	
	public void addMajor(String major) {
		if(!majors.contains(major)) {
			majors.add(major);
		}
	}
	
}
