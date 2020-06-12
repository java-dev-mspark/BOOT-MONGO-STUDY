package com.mspark.mongostudy.service;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.common.collect.Lists;
import com.mspark.mongostudy.domain.mongo.hakryuck.Hakryuck;
import com.mspark.mongostudy.domain.mongo.hakryuck.HighSchool;
import com.mspark.mongostudy.domain.mongo.hakryuck.HighSchoolType;
import com.mspark.mongostudy.domain.mongo.hakryuck.ScholarType;
import com.mspark.mongostudy.domain.mongo.hakryuck.University;
import com.mspark.mongostudy.domain.mysql.Member;
import com.mspark.mongostudy.repository.mongo.HakryuckRepository;
import com.mspark.mongostudy.repository.mysql.MemberRepository;
import com.mspark.mongostudy.service.impl.HakryuckServiceImpl;
import com.mspark.mongostudy.web.model.req.HakryuckRequest;

@SpringBootTest
public class HakryuckServiceTest {
	
	@Mock
	private MemberRepository memberRepository;
	
	@Mock
	private HakryuckRepository hakryuckRepository;
	
	private HakryuckServiceImpl hakryuckService;
	
	@BeforeEach
	void init() {
		hakryuckService = new HakryuckServiceImpl(memberRepository, hakryuckRepository);
	}
	
	@Test
	public void save_test() {
		//Given
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
		
		HakryuckRequest request = new HakryuckRequest(userid, highSchool, Lists.newArrayList(university));
		HakryuckRequest errorRequest = new HakryuckRequest("ERROR", highSchool, Lists.newArrayList(university));
		Hakryuck hakryuck = new Hakryuck(userid, highSchool, Lists.newArrayList(university));
		
		when(memberRepository.findById(userid)).thenReturn(Optional.ofNullable(new Member()));
		when(hakryuckRepository.save(any(Hakryuck.class))).thenReturn(hakryuck);
		
		Hakryuck savedHakryuck = hakryuckService.save(request);
		
		assertThrows(IllegalArgumentException.class, ()-> hakryuckService.save(null), "null 파라미터의 경우 예외를 발생시킨다 ");
		assertThrows(IllegalArgumentException.class, ()-> hakryuckService.save(errorRequest), "userid에 매핑되는 데이터가 없을경우 예외가 발생한다");
		
		assertThat("저장되면 객체를 리턴한다", savedHakryuck, is(notNullValue()));
		assertThat("저장된 객체는 일치한다", savedHakryuck, is(equalTo(hakryuck)));
		
		verify(memberRepository, times(1)).findById(userid);
		verify(memberRepository, times(1)).findById("ERROR");
		verify(hakryuckRepository, times(1)).save(any(Hakryuck.class));
		
	}
	
	
	@Test
	public void get_hakryuck_test() {
		
	}
}
