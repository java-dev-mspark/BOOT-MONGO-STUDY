package com.mspark.mongostudy.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mspark.mongostudy.domain.mysql.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

}
