package com.devs.member.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.devs.member.model.service.MemberService;

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
				.antMatchers("/user/myinfo").hasRole("MEMBER")//
				.antMatchers("/**").permitAll()//

				// 로그인 설정
				.and().formLogin()//
				.loginPage("/login")//
				.loginProcessingUrl("/loginProcess").defaultSuccessUrl("/result")//
				.permitAll()//
				.and()

				// 로그아웃 설정
				.logout()//
				.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))//
				.logoutSuccessUrl("/user/logout/result")//
				.invalidateHttpSession(true)//
				.and()
				
				// 403 예외처리 핸들링
				.exceptionHandling().accessDeniedPage("/user/denied");

		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().formLogin();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(service);
	}
}
