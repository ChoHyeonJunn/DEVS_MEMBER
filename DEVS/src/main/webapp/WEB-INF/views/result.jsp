<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�α��� ����</h1>
	
	${sessionScope.login }

	<!-- csrfȰ��ȭ ���¿��� get����� logout�� �������� �ʴ´�. -->	
	<form action="/logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<button type="submit" class="btn">Log out</button>
	</form>
</body>
</html>