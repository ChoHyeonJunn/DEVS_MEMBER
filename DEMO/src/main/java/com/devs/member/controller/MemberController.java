package com.devs.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

	@RequestMapping("/")
	public ModelAndView root() {
		System.out.println("root request");
		return new ModelAndView("home");
	}

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
