package com.devs.member.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devs.member.model.Repository.MemberRepository;
import com.devs.member.model.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public Map<String, Object> login(MemberVo vo) {
		Map<String, Object> map = null;

		MemberVo mres = memberRepository.findByMemberidAndMemberpassword(vo.getMemberemail(), vo.getMemberpassword());
		System.out.println(mres);
		if (mres != null) {
			map = new HashMap<>();
			map.put("login", mres);
			return map;
		} else {
			return map; // 멤버 정보를 가져오지 못했다면 null인 객체를 return
		}
	}

	@Override
	public int join(MemberVo vo) {
		return 0;
	}

	@Override
	public int emailCheck(MemberVo vo) {
		return 0;
	}

	@Override
	public int idCheck(MemberVo vo) {
		return 0;
	}

	@Override
	public MemberVo snsLogin(MemberVo vo) {
		return null;
	}

}