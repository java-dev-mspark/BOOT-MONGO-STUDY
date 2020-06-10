package com.mspark.mongostudy.domain.mongo.hakryuck;

import lombok.Getter;

@Getter
public enum HighSchoolType {

	NORMAL(0), ENGINEERING(1), ECONOMY(2), FOREIGN(3);
	
	private int value;
	
	HighSchoolType(int value){
		this.value = value;
	}
	
	
}
