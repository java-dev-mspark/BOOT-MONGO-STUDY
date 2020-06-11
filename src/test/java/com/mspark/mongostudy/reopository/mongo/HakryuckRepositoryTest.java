package com.mspark.mongostudy.reopository.mongo;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.google.common.collect.Lists;
import com.mspark.mongostudy.domain.mongo.hakryuck.Hakryuck;
import com.mspark.mongostudy.domain.mongo.hakryuck.HighSchool;
import com.mspark.mongostudy.domain.mongo.hakryuck.HighSchoolType;
import com.mspark.mongostudy.domain.mongo.hakryuck.ScholarType;
import com.mspark.mongostudy.domain.mongo.hakryuck.University;
import com.mspark.mongostudy.repository.mongo.HakryuckRepository;

@DataMongoTest
public class HakryuckRepositoryTest {

	@Autowired
	HakryuckRepository hakryuckRepository;

	@Test
	@DisplayName("학력 정보 저장 테스트")
	public void save_test() {
		String userid = UUID.randomUUID().toString();
		
		HighSchool highSchool = HighSchool.builder()
										  .name("고등학교")
										  .beginningDate("200803")
										  .endDate("201102")
										  .scholarTypeValue(ScholarType.HIGH.getValue())
										  .location("서울")
										  .highSchoolTypeValue(HighSchoolType.NORMAL.getValue())
										  .build();
										  
		University university = University.builder()
										  .name("대학교")
										  .beginningDate("201203")
										  .endDate("201502")
										  .scholarTypeValue(ScholarType.BACHELOR.getValue())
										  .location("서울")
										  .maxGrade(4.5)
										  .grede(3.9)
										  .majors(Lists.newArrayList("Chemical Science"))
										  .build();
		
		Hakryuck hakRyuck = new Hakryuck(userid, highSchool, Lists.newArrayList(university));
		
		hakryuckRepository.save(hakRyuck);

		Optional<Hakryuck> hakRyuckOptional = hakryuckRepository.findById(userid);
		
		assertThat("저장된 객체가 조회된다", hakRyuckOptional.isPresent(), is(true));
		assertThat("저장된 객체와 요청 객체는 동일하다",hakRyuck, is(equalTo(hakRyuckOptional.get())));
	}
	
	@Test
	@DisplayName("학력 정보 업데이트 테스트")
	public void update_test() {
		String userid = UUID.randomUUID().toString();
		
		HighSchool highSchool = HighSchool.builder()
										  .name("고등학교")
										  .beginningDate("200803")
										  .endDate("201102")
										  .scholarTypeValue(ScholarType.HIGH.getValue())
										  .location("서울")
										  .highSchoolTypeValue(HighSchoolType.NORMAL.getValue())
										  .build();
		
		HighSchool highSchool2 = HighSchool.builder()
										   .name("고등학교")
										   .beginningDate("200803")
										   .endDate("201102")
										   .scholarTypeValue(ScholarType.HIGH.getValue())
										   .location("부산")
										   .highSchoolTypeValue(HighSchoolType.NORMAL.getValue())
										   .build();
										  
		University university = University.builder()
										  .name("대학교")
										  .beginningDate("201203")
										  .endDate("201502")
										  .scholarTypeValue(ScholarType.BACHELOR.getValue())
										  .location("서울")
										  .maxGrade(4.5)
										  .grede(3.9)
										  .majors(Lists.newArrayList("Chemical Science"))
										  .build();
		
		Hakryuck hakRyuck = new Hakryuck(userid, highSchool, Lists.newArrayList(university));
		
		hakryuckRepository.save(hakRyuck);
		
		Optional<Hakryuck> hakRyuckOptional = hakryuckRepository.findById(userid);

		Hakryuck selectedResult = hakRyuckOptional.get();
		
		assertThat("수정 전 고등학교 위치는 서울 이다 ", selectedResult.getHighSchool().getLocation(), is(equalTo("서울")));
		assertThat("수정 전 전체 로우 갯수는 1 이다", hakryuckRepository.findAll().size(), is(equalTo(1)));
		
		selectedResult.setHighSchool(highSchool2);
		
		hakryuckRepository.save(selectedResult);
		
		Optional<Hakryuck> modifiedHakryuckOptional = hakryuckRepository.findById(userid);
	
		Hakryuck modifiedHakryuck = modifiedHakryuckOptional.get();
		
		assertThat("수정 전 객체와 수정 후 객체는 동일하다", modifiedHakryuck, is(equalTo(selectedResult)));
		assertThat("수정 후 전체 로우 갯수는 1 이다", hakryuckRepository.findAll().size(), is(equalTo(1)));
	}

	@Test
	@DisplayName("학력 정보 삭제 테스트")
	public void delete_test() {
String userid = UUID.randomUUID().toString();
		
		HighSchool highSchool = HighSchool.builder()
										  .name("고등학교")
										  .beginningDate("200803")
										  .endDate("201102")
										  .scholarTypeValue(ScholarType.HIGH.getValue())
										  .location("서울")
										  .highSchoolTypeValue(HighSchoolType.NORMAL.getValue())
										  .build();
										  
		University university = University.builder()
										  .name("대학교")
										  .beginningDate("201203")
										  .endDate("201502")
										  .scholarTypeValue(ScholarType.BACHELOR.getValue())
										  .location("서울")
										  .maxGrade(4.5)
										  .grede(3.9)
										  .majors(Lists.newArrayList("Chemical Science"))
										  .build();
		
		Hakryuck hakRyuck = new Hakryuck(userid, highSchool, Lists.newArrayList(university));
		
		hakryuckRepository.save(hakRyuck);
		
		assertThat("삭제 전 전체 로우 갯수는 1 이다", hakryuckRepository.findAll().size(), is(equalTo(1)));
		
		Hakryuck savedHakryuck =hakryuckRepository.findById(userid).get(); 
		
		hakryuckRepository.delete(savedHakryuck);
		
		assertThat("삭제 후 데이터는 조회되지 않는다", hakryuckRepository.findById(userid).isPresent(), is(false));
		assertThat("삭제 후 전체 로우 갯수는 1 이다", hakryuckRepository.findAll().size(), is(equalTo(0)));

	}
}
