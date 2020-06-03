package com.mspark.mongostudy;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoDatabase;
import com.mspark.mongostudy.dto.Person;
import com.mspark.mongostudy.repository.PersonRepository;


@SpringBootApplication
public class MongoDbStudyApplication {

	@Autowired
	MongoDatabaseFactory mongoDatabaseFactory;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	PersonRepository personRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MongoDbStudyApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner() {
		return args ->{
//			MongoDatabase db = mongoDatabaseFactory.getMongoDatabase();
//			db.getCollection("person").insertOne(new Document().append("name", "minsoo").append("job", "developer"));
//			
//			mongoTemplate.insert(Person.builder().name("noni").job("developer").build());
//		
//			personRepository.deleteAll();
//			
//			Person p1 = Person.builder().name("test").job("test").build();
//			Person p2 = Person.builder().name("test2").job("test").build();
//
//			personRepository.save(p1);
//			personRepository.save(p2);
//			
//			personRepository.findByJob("test").ifPresent(list -> list.toString());
	
		};
	}
}
