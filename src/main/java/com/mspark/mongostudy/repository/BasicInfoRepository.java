package com.mspark.mongostudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mspark.mongostudy.domain.BasicInfo;

public interface BasicInfoRepository extends MongoRepository<BasicInfo, String> {

}
