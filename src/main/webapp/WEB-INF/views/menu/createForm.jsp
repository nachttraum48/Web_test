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
	<h3>게시판 메뉴 만들기</h3>
	
	<form action="/Menu/Create" id='Form' method="post">
		<span>메뉴 이름</span> <input type="text" maxlength="10" name="menuname">
		<br>
		<br>
		<input type="submit" value="메뉴 만들기">
	</form>
</body>
</html>