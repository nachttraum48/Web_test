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
	
	$(document).submit(function(e){
	    var useridEl = document.getElementById('userid');
	    var userid = useridEl.value
	    var userpwEl = document.getElementById('userpw');
	    var userpw = userpwEl.value
		
	    if ( userid == null || userid == '' ){
	        alert('아이디를 입력해주세요.');
	        useridEl.focus();
	        return false;
	    }
	    if ( userpw == null || userpw == '' ){
	        alert('비밀번호를 입력해주세요.');
	        userpwEl.focus();
	        return false;
	    }
	 })
	
</script>
</head>

<body>
	<h2>로그인</h2>
	<form action="/Login/Login" method="POST">
		<p style="color:red;">${msg}<p>
		<span>ID</span>	<input type="text" maxlength="20" name="userid" id="userid">
		<br>
		<span>PW</span>	<input type="password" maxlength="20" name="userpw" id="userpw">
		<br>
		<br>
		<input type="submit" value="로그인">
	</form>
	<a href="/User/AccountForm">회원가입</a>
</body>
</html>