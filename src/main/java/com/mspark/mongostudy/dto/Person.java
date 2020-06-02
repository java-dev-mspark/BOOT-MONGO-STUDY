package com.mspark.mongostudy.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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
	
	@Indexed(unique = true)
	private String name;
	
	private String job;

	protected Person() {}

	@Builder
	public Person(String id, String name, String job) {
		this.id = id;
		this.name = name;
		this.job = job;
	}
	
}
