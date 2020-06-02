package com.mspark.mongostudy.reopository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.mspark.mongostudy.dto.Person;
import com.mspark.mongostudy.repository.PersonRepository;

@DataMongoTest
public class PersonRepositoryTest {

	@Autowired
	PersonRepository personRepository;
	
	@Test
	public void findByJobTest() {
		Person p = Person.builder().name("test").job("developer").build();
		Person p2 = Person.builder().name("test2").job("developer").build();
		
		personRepository.save(p).block();
		personRepository.save(p2).block();
		
		List<Person> list = personRepository.findByJob("developer").collectList().block();	
		
		assertThat(list.size()).isEqualTo(2);
		assertThat(list).contains(p);
	}
}
