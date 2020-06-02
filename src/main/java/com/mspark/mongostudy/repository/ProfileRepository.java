package com.mspark.mongostudy.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.mspark.mongostudy.domain.Profile;

public interface ProfileRepository extends ReactiveMongoRepository<Profile, String> {

}
