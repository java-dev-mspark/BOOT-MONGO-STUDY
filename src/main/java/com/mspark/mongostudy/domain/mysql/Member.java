package com.mspark.mongostudy.domain.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name ="member_tb")
@ToString @Getter @AllArgsConstructor @NoArgsConstructor
public class Member {

	@Id
	@Column(name = "member_id", unique = true)
	private String id;
	
	private String type;
}
