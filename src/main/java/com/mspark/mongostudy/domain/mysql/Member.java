package com.mspark.mongostudy.domain.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="member_tb")
@Data @AllArgsConstructor @NoArgsConstructor
public class Member {

	@Id
	@Column(name = "member_id", unique = true)
	private String id;
	
	private String type;
}
