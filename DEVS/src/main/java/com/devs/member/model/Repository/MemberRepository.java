package com.devs.member.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devs.member.model.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

	// 로그인
	public Member findByMemberemailAndMemberpassword(String memberemail, String memberpassword);

	public Member findByMemberphoneAndMemberpassword(String memberphone, String memberpassword);

	public Member findByMemberidAndMemberpassword(String memberid, String memberpassword);

	public Member findByMemberid(String memberid);

}
