package com.devs.member.model.service;

import java.util.Map;

import com.devs.member.model.vo.MemberVo;

public interface MemberService {

	// 로그인
	public Map<String, Object> login(MemberVo vo);

	// 회원가입
	public int join(MemberVo vo);

	// 이메일 유효성 검증
	public int emailCheck(MemberVo vo);

	// 아이디 유효성 검증
	public int idCheck(MemberVo vo);

	// sns로그인
	public MemberVo snsLogin(MemberVo vo);

}