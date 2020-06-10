package com.mspark.mongostudy.reopository.mongo;

import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.mspark.mongostudy.domain.mongo.hakryuck.Hakryuck;
import com.mspark.mongostudy.repository.mongo.HakryuckRepository;

@DataMongoTest
public class HakryuckRepositoryTest {

	@Autowired
	HakryuckRepository hakryuckRepository;

	@Test
	@DisplayName("학력 정보 저장 테스트")
	public void save_test() {
		String userid = UUID.randomUUID().toString();
		
		Hakryuck hakryuck = new Hakryuck();
	}
	
	@Test
	@DisplayName("학력 정보 업데이트 테스트")
	public void update_test() {
		
	}

	@Test
	@DisplayName("학력 정보 삭제 테스트")
	public void delete_test() {
		
	}
}
