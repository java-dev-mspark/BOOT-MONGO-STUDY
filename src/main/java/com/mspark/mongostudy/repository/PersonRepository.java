package com.mspark.mongostudy.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.mspark.mongostudy.dto.Person;

import reactor.core.publisher.Flux;

public interface PersonRepository extends ReactiveMongoRepository<Person, String> {

	Flux<Person> findByJob(String job);
}
