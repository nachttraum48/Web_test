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
	
	<c:if test="${adminToken ne null && adminToken eq '1'}">
		<a href="/Menu/List">메뉴 편집</a>
	</c:if>
	<br>
	<!-- 메뉴 테이블 -->
	<table border="1">
		<tr>
		<th><a href="/Board/List">전체</a></th>
		</tr>
	</table>
	<br>
	<!-- 게시글 테이블 -->
	<table border="1">
		<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일자</th>
		<th>조회 수</th>
		</tr>
		<c:forEach items="${list}" var="m">
		<tr>
		<td>${m.boardidx}</td>
		<td><a href="">${m.boardtitle}</a></td>
		<td>${m.boardwriter}</td>
		<td>${m.boardindate}</td>
		<td>${m.readcount}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>