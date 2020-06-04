package com.mspark.mongostudy;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.bson.BsonBinarySubType;
import org.bson.Document;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoDatabase;
import com.mspark.mongostudy.domain.BasicInfo;
import com.mspark.mongostudy.domain.Person;
import com.mspark.mongostudy.repository.BasicInfoRepository;
import com.mspark.mongostudy.repository.PersonRepository;


@SpringBootApplication
public class MongoDbStudyApplication {

	@Autowired
	MongoDatabaseFactory mongoDatabaseFactory;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	PersonRepository personRepository;

	@Autowired
	BasicInfoRepository basicInfoRepository;
	
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
			
//			Base64.getEncoder().encodeToString(Files.readAllBytes(new ClassPathResource("/test.png").getFile().toPath()));
//			
//			
//			BasicInfo bi = BasicInfo
//							.builder()
//							.id(UUID.randomUUID().toString())
//							.name("TEST")
//							.phonenumber("1234")
//							.email("TEST@AAA.COM")
//							.image(new Binary(BsonBinarySubType.BINARY, Files.readAllBytes(new ClassPathResource("/test.png").getFile().toPath())))
//							.build();
//			
//			basicInfoRepository.deleteAll();
//			
//			basicInfoRepository.save(bi);
//			
//			basicInfoRepository.findAll().forEach(System.out::println);;
	
		};
	}
}
