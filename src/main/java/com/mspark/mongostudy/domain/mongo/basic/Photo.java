package com.mspark.mongostudy.domain.mongo.basic;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter @EqualsAndHashCode 
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Document(value = "photo")
public class Photo {

	@Id
	@Indexed(unique = true)
	private String id;
	
	private Binary image;

	@Builder
	public Photo(String id, Binary image) {
		this.id = id;
		this.image = image;
	}
}
