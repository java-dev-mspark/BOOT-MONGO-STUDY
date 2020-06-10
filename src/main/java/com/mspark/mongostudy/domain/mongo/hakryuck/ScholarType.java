package com.mspark.mongostudy.domain.mongo.hakryuck;

import lombok.Getter;

@Getter
public enum ScholarType {

	HIGH(0), ASSOCIATE(1), BACHELOR(2), MASTER(3), DOCTOR(4);
	
	private int value;
	
	ScholarType(int value){
		this.value = value;
	}

}
