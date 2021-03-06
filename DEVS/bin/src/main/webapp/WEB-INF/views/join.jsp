<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<section>
	 	
		
		<div>
			<h1>
				DEVS
			</h1>
			<h3>
				친구들의 사진과 동영상을 보려면 가입하세요.
			</h3>
			
			<div>
				<span>
					<a id="custom-login-btn" href="javascript:loginWithKakaoRest()">
						<img src="/resources/images/social/kakaolink_btn_medium.png" width="100px;"/>
					</a>
				</span>
				<span>
					<a id="naver_id_login"></a>
				</span>
			</div>	
			
			<div>
				<hr>
			</div>
			
			<div>		
				<form id="joinForm" action="/join" method="post">
					<!-- 이메일 -->
					<input id="member_email" type="text" name="member_email" required="required" placeholder="휴대폰 번호 또는 이메일 주소">
					
					<!-- 성명 -->
					<input id="member_name" type="text" name="member_name" required="required" placeholder="성명">
					
					<!-- 사용자 이름 -->
					<input id="member_id" type="text" name="member_id" required="required" placeholder="사용자 이름">
					
					<!-- 비밀번호 -->
					<input id="member_pw" type="password" name="member_pw" required="required" placeholder="비밀번호">
					
					<!-- 회원가입 버튼 -->					
					<input type="button" value="회원가입" onclick="join();">
					
					<!-- 유효성검층 출력부분 -->					
					<div id="joinchk"></div>
				</form>

			</div>		
			
		</div>

	 
 		<div>
			계정이 있으신가요?
			<a href="/">&nbsp;로그인 </a>
		</div>
	</section>
</body>
</html>