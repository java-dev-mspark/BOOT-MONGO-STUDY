package com.mspark.mongostudy.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mspark.mongostudy.domain.mongo.hakryuck.Hakryuck;

public interface HakryuckRepository extends MongoRepository<Hakryuck, String> {

}
