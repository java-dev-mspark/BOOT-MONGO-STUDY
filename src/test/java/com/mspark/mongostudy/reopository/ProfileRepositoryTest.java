package com.mspark.mongostudy.reopository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.mspark.mongostudy.domain.Profile;
import com.mspark.mongostudy.repository.ProfileRepository;

@DataMongoTest
public class ProfileRepositoryTest {

	@Autowired
	ProfileRepository profileRepository;
	
	@Test
	public void save_test() {

		String userid = UUID.randomUUID().toString();
		
		Profile userProfile = Profile.builder().id(userid).email("testEmail").phonenumber("01012345678").name("aaaa").build();
		
		profileRepository.save(userProfile);
		
		Optional<Profile> expectedProfile = profileRepository.findById(userid);
		
		assertThat(expectedProfile.get()).isEqualTo(userProfile);
		
	}
}
