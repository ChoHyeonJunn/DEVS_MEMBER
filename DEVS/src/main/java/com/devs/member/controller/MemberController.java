package com.devs.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.devs.member.model.entity.Member;
import com.devs.member.model.service.MemberService;
import com.devs.member.model.vo.MemberVo;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	private static final String kakaoLoginLink = "https://kauth.kakao.com/oauth/authorize?client_id=d79e80b7ce7ff5ddf655cab6351ef911&redirect_uri=http://localhost:8787/member/oauth&response_type=code";

	/*
	 * test
	 */
	@PreAuthorize("hasRole('MEMBER')")
	@GetMapping("/result")
	public ModelAndView resultPage() {
		return new ModelAndView("result");
	}

	/*
	 * 페이지 처리
	 */
	// 루트 - 로그인 페이지
	@RequestMapping("/")
	public ModelAndView rootPage(Model model) {
		System.out.println("root request!!!");
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
	@PostMapping("/join")
	public ModelAndView joinProcess(MemberVo vo) {

		System.out.println("controller : >>>" + vo);

		memberService.join(vo);
		return new ModelAndView("root");
	}

	// login ajax 처리
	@PostMapping(value = "/login")
	public Map<String, Boolean> login(HttpSession session, @RequestBody Member vo) {
		System.out.println(vo);
		Map<String, Object> res = memberService.login(vo);
		memberService.loadUserByUsername(vo.getMemberid());
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
