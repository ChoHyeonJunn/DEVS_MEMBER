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
				ģ������ ������ �������� ������ �����ϼ���.
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
					<!-- �̸��� -->
					<input id="member_email" type="text" name="member_email" required="required" placeholder="�޴��� ��ȣ �Ǵ� �̸��� �ּ�">
					
					<!-- ���� -->
					<input id="member_name" type="text" name="member_name" required="required" placeholder="����">
					
					<!-- ����� �̸� -->
					<input id="member_id" type="text" name="member_id" required="required" placeholder="����� �̸�">
					
					<!-- ��й�ȣ -->
					<input id="member_pw" type="password" name="member_pw" required="required" placeholder="��й�ȣ">
					
					<!-- ȸ������ ��ư -->					
					<input type="button" value="ȸ������" onclick="join();">
					
					<!-- ��ȿ������ ��ºκ� -->					
					<div id="joinchk"></div>
				</form>

			</div>		
			
		</div>

	 
 		<div>
			������ �����Ű���?
			<a href="/">&nbsp;�α��� </a>
		</div>
	</section>
</body>
</html>