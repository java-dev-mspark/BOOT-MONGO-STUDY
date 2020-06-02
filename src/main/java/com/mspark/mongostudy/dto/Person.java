package com.mspark.mongostudy.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString @Getter @EqualsAndHashCode
@Document(collection = "person")
public class Person {

	@Id
	private String id;
	
	private String name;
	
	private String job;

	protected Person() {}

	@Builder
	public Person(String name, String job) {
		this.name = name;
		this.job = job;
	}
	
}
