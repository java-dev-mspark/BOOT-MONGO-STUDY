package com.mspark.mongostudy.domain.mongo.hakryuck;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "hakryuck")
@Getter @ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
public class Hakryuck {

	@Id
	@Indexed(unique = true)
	private String id;

	private HighSchool highSchool;
	
	private List<University> universitis;
	
}
