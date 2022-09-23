<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	
</script>
</head>

<body>
	<h2>로그인</h2>
	<form action="/User/LoginCheck" method="POST">
		<c:if test="${msg == false}">
			<p style="color: red;">로그인 실패! 아이디와 비밀번호 확인해주세요.</p>
		</c:if>
		<span>ID</span>	<input type="text" maxlength="20" name="userid">
		<br>
		<span>PW</span>	<input type="password" maxlength="20" name="userpw">
		<br>
		<input type="submit" value="로그인">
	</form>
	<a href="/User/AccountForm">회원가입</a>
	<a href="/">메인화면</a>
</body>
</html>