package com.mspark.mongostudy.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.mspark.mongostudy.domain.BasicInfo;
import com.mspark.mongostudy.repository.BasicInfoRepository;
import com.mspark.mongostudy.service.impl.BasicInfoServiceImpl;
import com.mspark.mongostudy.web.model.req.BasicInfoRequest;

@SpringBootTest
public class BasicInfoServiceTest {

	@Mock
	BasicInfoRepository basicInfoRepository;
	
	BasicInfoServiceImpl basicInfoService;
	
	@BeforeEach
	void init() {
		basicInfoService = new BasicInfoServiceImpl(basicInfoRepository);
	}
	
	@Test
	@DisplayName(value ="BasicInfo 조회 테스트")
	public void get_basic_info_test() throws FileNotFoundException, IOException {
		//Given
		String userid = UUID.randomUUID().toString();
		String name = "name";
		String email = "email";
		String phoneNumber = "01012345678";
		
		MultipartFile multipartFile = new MockMultipartFile("test.png", new FileInputStream(new ClassPathResource("/test.png").getFile()));
		
		BasicInfo userProfile = BasicInfo
									.builder()
									.id(userid)
									.name(name)
									.email(email)
									.phonenumber(phoneNumber)
									.image(new Binary(BsonBinarySubType.BINARY, multipartFile.getBytes()))
									.build();
		
		when(basicInfoRepository.findById(userid)).thenReturn(Optional.of(userProfile));
		
		assertThrows(IllegalArgumentException.class, ()-> {basicInfoService.getBasicInfo(null);}, "유저아이디 파라미터가 넘어오지 않으면 예외가 발생한다");
		assertThrows(IllegalArgumentException.class, ()-> {basicInfoService.getBasicInfo("");}, "빈값의 유저아이디 파라미터가 넘어오면 예외가 발생한다");
		assertThrows(IllegalStateException.class, ()-> {basicInfoService.getBasicInfo("1234");}, "데이터가 없을 경우 예외가 발생한다");
		
		BasicInfo basicInfo = basicInfoService.getBasicInfo(userid);
		
		assertThat("Entity 객체가 올바르게 조회 되어야 한다", basicInfo, is(equalTo(userProfile)));
		
		verify(basicInfoRepository, times(1)).findById(userid);
		
	}
	
	@Test
	@DisplayName(value ="BasicInfo 저장 테스트")
	public void save_basic_info_test() throws FileNotFoundException, IOException {

		//Given
		String userid = UUID.randomUUID().toString();
		String name = "name";
		String email = "email";
		String phoneNumber = "01012345678";
		
		MultipartFile multipartFile = new MockMultipartFile("test.png", new FileInputStream(new ClassPathResource("/test.png").getFile()));
		
		BasicInfo userProfile = BasicInfo
									.builder()
									.id(userid)
									.name(name)
									.email(email)
									.phonenumber(phoneNumber)
									.image(new Binary(BsonBinarySubType.BINARY, multipartFile.getBytes()))
									.build();
		
		BasicInfoRequest request = new BasicInfoRequest(name, email, phoneNumber, multipartFile);
		
		when(basicInfoRepository.save(any(BasicInfo.class))).thenReturn(userProfile);
		when(basicInfoRepository.findById(userid)).thenReturn(Optional.of(userProfile));
		
		assertThrows(IllegalArgumentException.class, ()->{basicInfoService.save(null);}, "파라미터 객체가 넘어오지 않은경우 예외가 발생한다");
		assertThat("저장이 되면 객체를 리턴한다", basicInfoService.save(request), is(equalTo(userProfile)));
	}
	
}
