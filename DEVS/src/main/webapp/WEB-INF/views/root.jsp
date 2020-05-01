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
				<form action="/loginProcess" method="post">			
					<!-- �̸��� -->
					<input type="text" name="member_id" required="required" placeholder="��ȭ��ȣ, ����� �̸� �Ǵ� �̸���">
					
					<!-- ��й�ȣ -->
					<input type="password" name="member_password" required="required" placeholder="��й�ȣ">
					
					<!-- �α��� ��ư -->
					<input type="button" value="�α���" onclick="login();">
					<input type="submit" value="security�α���">
				</form>
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
				
				<!-- ��ȿ������ ��ºκ� -->
				<div id="loginchk"></div>
				
				<div>
					<a href="#">��й�ȣ�� �����̳���?</a>
				</div>
			</div>			
			
		</div>

	 
	 	<div>
			������ �����Ű���?
			<a href="/join">&nbsp;�����ϱ� </a>
		</div>
	</section>

	
	<section>
		<h1>����Ʈ�Ұ�</h1>
		
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
			
			// �̸��� ���Խ�
			var regExpEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
			
			// �ڵ�����ȣ ���Խ� (010-1234-1234)
			var regExpPhone = /^\d{3}-\d{4}-\d{4}$/;
			
			var member_id = $("input[name='member_id']").val();
			var member_password = $("input[name='member_password']").val();
			
			if(regExpEmail.test(member_id)) { // �̸��� �����̶��
				
				var loginVal = {
						"memberemail" : member_id,
						"memberpassword" : member_password
				}
			
			} else if(regExpPhone.test(member_id)) {	// �ڵ�����ȣ �����̶��
				
				member_id = member_id.split("-").join("");
				alert(member_id);
			
				var loginVal = {
						"memberphone" : member_id,
						"memberpassword" : member_password
				}
			
			} else {		// ���̵���
				
				var loginVal = {
						"memberid" : member_id,
						"memberpassword" : member_password
				}
				
			}
			
			if(member_id == null || member_id == "" 
					|| member_password == null || member_password == ""){
				alert("�Է��� ����� �̸��� ����ϴ� ������ ã�� �� �����ϴ�. ����� �̸��� Ȯ���ϰ� �ٽ� �õ��ϼ���.")
			}else{
				
				$.ajax({
					type: "post",
					url: "/login",
					data: JSON.stringify(loginVal),
					contentType: "application/json",
					dataType: "json",
					
					success: function(msg){
						
						if (msg.check == true) {
							location.href="/result";
						} else {
							$("#loginchk").show().html("�Է��� ����� �̸��� ����ϴ� ������ ã�� �� �����ϴ�. ����� �̸��� Ȯ���ϰ� �ٽ� �õ��ϼ���.").css("color","red")
						}
		
					},
					
					error: function(){
						alert("��Ž���");
					}
				})
			}
			
		}
	</script>
<!-- END :: Ajax login -->

</html>