package com.devs.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.devs.member.model.service.MemberService;
import com.devs.member.model.vo.MemberVo;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;

	private static final String kakaoLoginLink = "https://kauth.kakao.com/oauth/authorize?client_id=d79e80b7ce7ff5ddf655cab6351ef911&redirect_uri=http://localhost:8787/member/oauth&response_type=code";

	/*
	 * test
	 */
	@GetMapping("/result")
	public ModelAndView resultPage() {
		return new ModelAndView("result");
	}

	/*
	 * 페이지 처리
	 */
	// 루트 - 로그인 페이지
	@GetMapping("/")
	public ModelAndView rootPage(Model model) {

		// kakao login 링크
		model.addAttribute("kakaoLoginLink", kakaoLoginLink);

		// naver login 링크

		return new ModelAndView("root");
	}

	// 회원가입 페이지
	@GetMapping("/join")
	public ModelAndView joinPage(Model model) {

		// kakao login 링크
		model.addAttribute("kakaoLoginLink", kakaoLoginLink);

		// naver login 링크

		return new ModelAndView("join");
	}

	/*
	 * 유효성 검증
	 */

	/*
	 * 회원가입 / 로그인 처리
	 */
	// login ajax 처리
	@PostMapping(value = "/login")
	public Map<String, Boolean> login(HttpSession session, @RequestBody MemberVo vo) {
		System.out.println(vo);
		Map<String, Object> res = memberService.login(vo);
		boolean check = false;

		if (res != null) {
			session.setAttribute("login", res.get("login"));
			check = true;
		}

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);

		return map;
	}

	/*
	 * sns 연동 처리
	 */
}