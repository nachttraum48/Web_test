<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<a href="/User/UpdateUserForm?username=${detailUser.USERNAME}&userid=${detailUser.USERID}">수정</a>
	<a href="/User/DeleteUser?userid=${detailUser.USERID}">삭제</a>
</body>
</html>