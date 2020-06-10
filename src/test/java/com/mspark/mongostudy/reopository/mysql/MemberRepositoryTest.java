package com.mspark.mongostudy.reopository.mysql;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.mspark.mongostudy.domain.mysql.Member;
import com.mspark.mongostudy.repository.mysql.MemberRepository;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {

	@Autowired
	MemberRepository memberRepository;

	@Test
	public void save_test() {
		//Given
		String id = UUID.randomUUID().toString();
		String type = "member";
		
		Member member = new Member(id, type);
		
		//When
		memberRepository.save(member);
		
		//Then
		Optional<Member> savedMemberOptional = memberRepository.findById(id);
		
		assertThat("조회된 객체와 저장 객체는 같아야 한다", savedMemberOptional.get(), is(equalTo(member)));
		
	}
}
