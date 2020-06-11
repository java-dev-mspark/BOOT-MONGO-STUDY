package com.mspark.mongostudy.domain.mongo.hakryuck;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public abstract class Scholar {

	protected String name;
	protected String beginningDate;
	protected String endDate;
	protected int scholarTypeValue;
	
}
