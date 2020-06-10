package com.mspark.mongostudy.reopository.mongo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.mspark.mongostudy.domain.mongo.basic.BasicInfo;
import com.mspark.mongostudy.repository.mongo.BasicInfoRepository;

@DataMongoTest
public class BasicInfoRepositoryTest {

	@Autowired
	BasicInfoRepository basicInfoRepository;
	
	@Test
	public void save_test() {

		//Given
		String userid = UUID.randomUUID().toString();
		
		BasicInfo userProfile = BasicInfo
									.builder()
									.id(userid)
									.name("name")
									.email("testEmail")
									.phonenumber("01012345678")
									.build();
		
		//When
		basicInfoRepository.save(userProfile);
		
		Optional<BasicInfo> optionalBasicInfo = basicInfoRepository.findById(userid);
		
		assertThat("데이터가 제대로 조회된다", optionalBasicInfo.isPresent(), is(true));
		assertThat("조회한 객체와 저장한 객체는 일치한다", optionalBasicInfo.get(), is(equalTo(userProfile)));
	}
	

	@Test
	public void update_test() throws FileNotFoundException, IOException {

		//Given
		String userid = UUID.randomUUID().toString();
		
		BasicInfo userProfile = BasicInfo
									.builder()
									.id(userid)
									.name("name")
									.email("testEmail")
									.phonenumber("01012345678")
									.build();
		
		//Insert and Select
		basicInfoRepository.save(userProfile);
		BasicInfo basicInfo = basicInfoRepository.findById(userid).get();
	
		
		assertThat("update 전 데이터는 'name' 이다.", basicInfo.getName(), is(equalTo("name")));
		
		//Update
		basicInfo.setName("changeName");
		basicInfoRepository.save(basicInfo);
		
		BasicInfo changedBasicInfo = basicInfoRepository.findById(userid).get();
		
		
		assertThat("변경 전/후 의 객체는 동일하다", changedBasicInfo, is(equalTo(basicInfo)));
		assertThat("데이터가 제대로 변경 되었다", changedBasicInfo.getName(), is(equalTo("changeName")));
		assertThat("변경 후 전체 entry 갯수는 1이다", basicInfoRepository.findAll().size(), is(equalTo(1)));
	}
}
