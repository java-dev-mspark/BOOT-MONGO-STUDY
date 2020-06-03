package com.mspark.mongostudy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mspark.mongostudy.dto.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

	Optional<List<Person>> findByJob(String job);
}
