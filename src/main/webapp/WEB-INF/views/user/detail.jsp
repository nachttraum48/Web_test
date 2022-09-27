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
	<h2>유저 상세정보</h2>
	<table border="1">
		<tr>
		<td><b>번호</b></td>
		<td>${detailUser.USERIDX}</td>
		</tr>
		<tr>
		<td><b>이름</b></td>
		<td>${detailUser.USERNAME}</td>
		</tr>
		<tr>
		<td><b>ID</b></td>
		<td>${detailUser.USERID}</td>
		</tr>
		<tr>
		<td><b>PW</b></td>
		<td>${detailUser.USERPW}</td>
		</tr>
		<tr>
		<td><b>생성일자</b></td>
		<td>${detailUser.USERINDATE}</td>
		</tr>
		<tr>
		<td><b>수정일자</b></td>
		<td>${detailUser.USERUPDATE}</td>
		</tr>
	</table>
	<br>
		<form action="/User/UpdateForm" method="POST">
		   <input type="hidden" value="${detail.USERNAME}" name="username">
		   <input type="hidden" value="${detail.USERID}" name="userid">
		   <input type="submit" value="수정">
		</form>
	<br>
		<form action="/User/Delete" method="POST">
		   <input type="hidden" value="${detail.USERID}" name="userid">
		   <input type="submit" value="삭제">
		</form>
	<br>
	<a href="/">메인화면</a>
</body>
</html>