package com.mspark.mongostudy.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.mspark.mongostudy.domain.mongo.hakryuck.Hakryuck;
import com.mspark.mongostudy.domain.mysql.Member;
import com.mspark.mongostudy.repository.mongo.HakryuckRepository;
import com.mspark.mongostudy.repository.mysql.MemberRepository;
import com.mspark.mongostudy.service.HakryuckService;
import com.mspark.mongostudy.web.model.req.HakryuckRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HakryuckServiceImpl implements HakryuckService {

	private final MemberRepository memberRepository;
	private final HakryuckRepository hakryuckRepository;
	
	@Override
	public Hakryuck save(HakryuckRequest request) {
		Assert.notNull(request, "The parameter is required");
		
		String userid = request.getUserid();
		
		Optional<Member> memberOptional = memberRepository.findById(userid);
		Assert.isTrue(memberOptional.isPresent(), "There are no member data");
		
		Hakryuck hakryuck = new Hakryuck(userid, request.getHighSchool(), request.getUniversities());
		
		return hakryuckRepository.save(hakryuck);
	}

	@Override
	public Hakryuck getHakryuck(String userid) {
		return null;
	}

}
