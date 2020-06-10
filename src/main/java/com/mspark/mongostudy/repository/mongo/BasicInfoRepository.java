package com.mspark.mongostudy.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mspark.mongostudy.domain.mongo.basic.BasicInfo;

public interface BasicInfoRepository extends MongoRepository<BasicInfo, String> {

}
