<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
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
				<form id="joinForm" action="/join" method="post" name="MemberVo">
					<!-- �̸��� -->
					<input type="text" name="memberemail" required="required" placeholder="�޴��� ��ȣ �Ǵ� �̸��� �ּ�">
					
					<!-- ���� -->
					<input type="text" name="membername" required="required" placeholder="����">
					
					<!-- ����� �̸� -->
					<input type="text" name="memberid" required="required" placeholder="����� �̸�">
					
					<!-- ��й�ȣ -->
					<input type="password" name="memberpassword" required="required" placeholder="��й�ȣ">
					
					<!-- ȸ������ ��ư -->					
					<input type="button" value="ȸ������" onclick="join();">
					<input type="submit" value="securityȸ������">
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