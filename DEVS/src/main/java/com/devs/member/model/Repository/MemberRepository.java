package com.devs.member.model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devs.member.model.vo.MemberVo;

@Repository
public interface MemberRepository extends JpaRepository<MemberVo, Integer> {

	// 로그인
	public MemberVo findByMemberidAndMemberpassword(String memberemail, String memberpassword);

}