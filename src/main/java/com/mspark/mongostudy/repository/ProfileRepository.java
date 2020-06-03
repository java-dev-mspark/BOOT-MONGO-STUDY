package com.mspark.mongostudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mspark.mongostudy.domain.Profile;

public interface ProfileRepository extends MongoRepository<Profile, String> {

}
