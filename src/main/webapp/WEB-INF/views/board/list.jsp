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
	<h2>게시판</h2>
	
	<c:if test="${user.adminToken ne null && user.adminToken eq '1'}">
		<a href="/Menu/List">메뉴 편집</a>
	<br>
	<br>
	</c:if>
	<!-- 메뉴 테이블 -->
	<table border="1">
		<tr>
		<th>
		<form action="/Board/List" method="POST">
			<input type="hidden" value="${user.userid}" name="userid">
			<input style="border: none; background: transparent;" type="submit" value="전체">
		</form>
		</th>
		<c:forEach items="${menu}" var="m">
			<th>
			<form action="/Board/SelectList" method="POST">
				<input type="hidden" value="${user.userid}" name="userid">
				<input type="hidden" value="${m.menuname}" name="menuname">
				<input style="border: none; background: transparent;" type="submit" value="${m.menuname}">
			</form>
			</th>
		</c:forEach>
		</tr>
	</table>
	<br>
	<!-- 게시글 테이블 -->
	<table border="1">
		<tr>
		<th>번호</th>
		<th>카테고리</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일자</th>
		<th>조회 수</th>
		</tr>
		<c:forEach items="${board}" var="m">
		<tr>
		<td>${m.boardidx}</td>
		<td>${m.boardmenu}</td>
		<td>
			<form action="/Board/Detail" method="POST">
				<input type="hidden" value="${m.boardtitle}" name="boardtitle">
				<input style="border: none; background: transparent;" type="submit" value="${m.boardtitle}">
			</form>
		</td>
		<td>${m.boardwriter}</td>
		<td>${m.boardindate}</td>
		<td>${m.readcount}</td>
		</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<form action="/Board/WriteForm" method="POST">
		<input type="submit" value="글쓰기">
	</form>
</body>
</html>