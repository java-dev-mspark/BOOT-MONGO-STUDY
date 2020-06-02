package com.mspark.mongostudy.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString @Getter @EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Profile {

	@Id
	@Indexed(unique = true)
	private String id;
	
	private String name;
	
	private String email;
	
	private String phonenumber;

	@Builder
	protected Profile(String id, String name, String email, String phonenumber) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
	}
	
}
