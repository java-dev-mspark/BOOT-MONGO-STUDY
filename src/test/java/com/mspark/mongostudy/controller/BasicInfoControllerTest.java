package com.mspark.mongostudy.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mspark.mongostudy.domain.mysql.Member;
import com.mspark.mongostudy.repository.mysql.MemberRepository;
import com.mspark.mongostudy.web.model.req.BasicInfoRequest;
import com.mspark.mongostudy.web.model.resp.BasicInfoResponse;

@WebAppConfiguration
@SpringBootTest
@Transactional
public class BasicInfoControllerTest {

	@Autowired
	private WebApplicationContext webContext;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private MemberRepository memberRepository;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	public void init() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
	}
	
	@Test
	public void save_basicInfo_test() throws Exception {
		String userid = UUID.randomUUID().toString();
		String name = "Test";
		String email = "aaa@aaa.com";
		String phonenumber = "01012341234";
		
		Member member = new Member(userid, "member");
		BasicInfoRequest request = new BasicInfoRequest(userid, name, email, phonenumber);
		
		memberRepository.save(member);
		
		String content = objectMapper.writeValueAsString(request);
		
		mockMvc.perform(post("/api/basicinfo/save")
							.contentType("application/json;charset=UTF-8")
							.content(content))
			   .andExpect(status().isOk())
			   .andDo(print());
		
	}

	@Test
	public void get_basicInfo_test() throws Exception {

		String userid = UUID.randomUUID().toString();
		String name = "Test";
		String email = "aaa@aaa.com";
		String phonenumber = "01012341234";
		
		Member member = new Member(userid, "member");
		BasicInfoRequest request = new BasicInfoRequest(userid, name, email, phonenumber);
		
		memberRepository.save(member);
		
		String content = objectMapper.writeValueAsString(request);
		
		mockMvc.perform(post("/api/basicinfo/save")
							.contentType("application/json;charset=UTF-8")
							.content(content))
			   .andExpect(status().isOk())
			   .andDo(print());
		
		
		mockMvc.perform(get("/api/basicinfo/" +"errorUserId"))
			   .andExpect(status().is5xxServerError())
			   .andDo(print());
		
		MvcResult result = mockMvc.perform(get("/api/basicinfo/"+ userid))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
	
		BasicInfoResponse response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<BasicInfoResponse>() {});
		
		assertThat("결과값을 제대로 가져온다", response, is(instanceOf(BasicInfoResponse.class)));
		assertThat("가져온 userid 정보가 동일하다", response.getBasicInfo().getId(), is(equalTo(userid)));
		assertThat("가져온 name 정보가 동일하다", response.getBasicInfo().getName(), is(equalTo(name)));
		assertThat("가져온 email 정보가 동일하다", response.getBasicInfo().getEmail(), is(equalTo(email)));
		assertThat("가져온 phonenumber 정보가 동일하다", response.getBasicInfo().getPhonenumber(), is(equalTo(phonenumber)));
		
	}
}
