<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<!-- START :: js import -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- END :: js import -->


</head>
<body>
	<section>
	 	
		
		<div>
			<h1>
				DEVS
			</h1>
			
			<div>							
				<!-- 이메일 -->
				<input type="text" name="member_email" required="required" placeholder="전화번호, 사용자 이름 또는 이메일">
				
				<!-- 비밀번호 -->
				<input type="password" name="member_password" required="required" placeholder="비밀번호">
				
				<!-- 로그인 버튼 -->
				<input type="button" value="로그인" onclick="login();">
			</div>
			
			<div>
				<hr>
			</div>
			
			<div>
				<span>
					<a id="custom-login-btn" href="javascript:loginWithKakaoRest()">
						<img src="/resources/images/social/kakaolink_btn_medium.png" width="100px;"/>
					</a>
				</span>
				<span>
					<a id="naver_id_login"></a>
				</span>
				
				<!-- 유효성검층 출력부분 -->
				<div id="loginchk"></div>
				
				<div>
					<a href="#">비밀번호를 잊으셨나요?</a>
				</div>
			</div>			
			
		</div>

	 
	 	<div>
			계정이 없으신가요?
			<a href="/join">&nbsp;가입하기 </a>
		</div>
	</section>

	
	<section>
		<h1>사이트소개</h1>
		
		<div>
	
		</div>
	</section>
	
	
	
</body>

<!-- START :: Ajax login -->
	<script type="text/javascript">	
		$(function(){
			$("#loginchk").hide();
		})
		
		function login(){
			var member_email = $("input[name='member_email']").val();
			var member_password = $("input[name='member_password']").val();
			
			if(member_email == null || member_email == "" 
					|| member_password == null || member_password == ""){
				alert("입력한 사용자 이름을 사용하는 계정을 찾을 수 없습니다. 사용자 이름을 확인하고 다시 시도하세요.")
			}else{
				
				$.ajax({
					type: "post",
					url: "/login",
					data: JSON.stringify({
						"memberemail" : member_email,
						"memberpassword" : member_password
					}),
					contentType: "application/json",
					dataType: "json",
					
					success: function(msg){
						
						if (msg.check == true) {
							location.href="/result";
						} else {
							$("#loginchk").show().html("입력한 사용자 이름을 사용하는 계정을 찾을 수 없습니다. 사용자 이름을 확인하고 다시 시도하세요.").css("color","red")
						}
		
					},
					
					error: function(){
						alert("통신실패");
					}
				})
			}
			
		}
	</script>
<!-- END :: Ajax login -->

</html>