package com.mspark.mongostudy.domain.mongo.hakryuck;

import lombok.Getter;

@Getter
public enum DayType {

	DAY(0), NIGHT(1);

	private int value;
	
	DayType(int value){
		this.value = value;
	}
	
}
