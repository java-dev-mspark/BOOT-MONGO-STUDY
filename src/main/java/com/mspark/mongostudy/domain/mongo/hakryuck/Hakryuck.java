package com.mspark.mongostudy.domain.mongo.hakryuck;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "hakryuck")
@Data
public class Hakryuck {

	@Id
	@Indexed(unique = true)
	private String id;
	
	private List<Scholar> scholars;
	
}
