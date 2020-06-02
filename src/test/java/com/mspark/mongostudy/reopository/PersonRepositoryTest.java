package com.mspark.mongostudy.reopository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.mspark.mongostudy.dto.Person;
import com.mspark.mongostudy.repository.PersonRepository;

import reactor.core.publisher.Mono;

@DataMongoTest
public class PersonRepositoryTest {

	@Autowired
	PersonRepository personRepository;
	
	
	public void save_test() {
		
	}
	
	@Test
	public void findByJobTest() {
		Person p = Person.builder().id(UUID.randomUUID().toString()).name("test").job("developer").build();
		Person p2 = Person.builder().id(UUID.randomUUID().toString()).name("test2").job("developer").build();
		
		Mono<Person> mono1 = personRepository.save(p);
		Mono<Person> mono2 = personRepository.save(p2);
		
		Mono<Void> all = Mono.when(mono1, mono2);
		
		all.block();

		List<Person> list = personRepository.findByJob("developer").collectList().block();	
		
		assertThat(list.size()).isEqualTo(2);
		assertThat(list).contains(p);		
	}
}
