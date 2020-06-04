package com.mspark.mongostudy.domain;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mspark.mongostudy.web.model.req.BasicInfoRequest;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter @EqualsAndHashCode 
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Document(collection = "basicinfo")
public class BasicInfo {

	@Id
	@Indexed(unique = true)
	private String id;
	
	private String name;
	
	private String email;
	
	private String phonenumber;
	
	private Binary image;

	@Builder
	protected BasicInfo(String id, String name, String email, String phonenumber, Binary image) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.image = image;
	}
	
	public void update(BasicInfoRequest request) {
		this.name = request.getName();
		this.email = request.getEmail();
		this.phonenumber = request.getPhonenumber();
		try {
			this.image = new Binary(BsonBinarySubType.BINARY, request.getImage().getBytes());
		}
		catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}
}
