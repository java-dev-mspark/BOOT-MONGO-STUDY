package com.mspark.mongostudy.reopository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.mspark.mongostudy.domain.Person;
import com.mspark.mongostudy.repository.PersonRepository;

@DataMongoTest
public class PersonRepositoryTest {

	@Autowired
	PersonRepository personRepository;
	
	@Test
	public void findByJobTest() {
		Person p = Person.builder().id(UUID.randomUUID().toString()).name("test").job("developer").build();
		Person p2 = Person.builder().id(UUID.randomUUID().toString()).name("test2").job("developer").build();
		
		personRepository.save(p);
		personRepository.save(p2);
		

		List<Person> list = personRepository.findByJob("developer").get();	
		
		assertThat(list.size()).isEqualTo(2);
		assertThat(list).contains(p);		
	}
}
