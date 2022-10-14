<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h2>home</h2>
	<a href="/Login/LoginForm">로그인</a>
	<br>
	<br>
	<form action="/Board/List" method="POST">
		<input type="hidden" value="" name="userid">
		<input type="submit" value="게시판 바로가기">
	</form>
</body>
</html>