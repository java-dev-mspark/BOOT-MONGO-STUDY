package com.mspark.mongostudy.domain.mysql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name ="member_tb")
@Data
public class Member {

	@Id
	private String id;
	
	private String type;
}
