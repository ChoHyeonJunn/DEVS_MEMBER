package com.devs.member.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.devs.member.model.service.MemberService;
import com.devs.member.security.handler.CustomUrlAuthenticationFailureHandler;
import com.devs.member.security.handler.CustomUrlAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MemberService service;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()

				// 페이지 권한 설정
				.antMatchers("/admin/**").hasRole("ADMIN")//
				.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")//
				.antMatchers("/**").permitAll()//
				.and()

				// 로그인 설정
				.formLogin()//
				.loginPage("/login")//
				.loginProcessingUrl("/loginProcess")//
				.successHandler(authenticationSuccessHandler())//
				.failureHandler(authenticationFailureHandler())//
				.failureForwardUrl("/login")//
				.usernameParameter("member_id").passwordParameter("member_password")//
				.permitAll()//
				.and()

				// 로그아웃 설정
				.logout()//
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))//
				.logoutSuccessUrl("/")//
				.invalidateHttpSession(true);
				//.and()

				// 403 예외처리 핸들링
				//.exceptionHandling().accessDeniedPage("/user/denied");
	}

	// AuthenticationSuccessHandler 등록 (로그인 성공시 핸들러)
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new CustomUrlAuthenticationSuccessHandler();
	}

	// AuthenticationSuccessHandler 등록 (로그인 실패시 핸들러)
	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
		return new CustomUrlAuthenticationFailureHandler();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service);
	}

	@Bean
	public BCryptPasswordEncoder pwEncode() {
		return new BCryptPasswordEncoder();
	}
}
