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
	<h2>회원목록</h2>
	<table border="1">
		<tr>
		<th>번호</th>
		<th>ID</th>
		<th>이름</th>
		<th>상세정보</th>
		</tr>
		<c:forEach items="${list}" var="m">
		<tr>
		<td>${m.useridx}</td>
		<td>${m.userid}</td>
		<td>${m.username}</td>
		<td>
		    <form action="/User/DetailAdmin" method="POST">
		    	<input type="hidden" value="${m.userid}" name="userid">
		    	<input type="submit" value="보기">
		    </form>
		</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>