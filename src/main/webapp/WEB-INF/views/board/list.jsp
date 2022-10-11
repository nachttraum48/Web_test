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
	
	function search() {
		var textEl = document.getElementById('text');
		var text = textEl.value
		
		if (text == null || text == '') {
			alert('검색어를 입력해주세요.');
			textEl.focus();
			return false;
		}
	}
	
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
				<input type="hidden" value="${user.userid}" name="userid">
				<input type="hidden" value="${m.boardidx}" name="boardidx">
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
	<!-- 게시글 검색 -->
	<form action="/Board/Search" method="POST" onsubmit="return search();">
	  	<input type="hidden" value="${user.userid}" name="userid">
	  	
		<select name="searchType" id="searchType">
	       <option value="title" selected="selected">제목</option>
	       <option value="content">내용</option>
	       <option value="writer">작성자</option>
	  	</select>
	  	
	  	<input type="text" name="searchText" id="searchText">
		<input type="submit" value="검색">
	</form>
	<br>
	<br>
	<form action="/Board/WriteForm" method="POST">
		<input type="hidden" value="${user.userid}" name="userid">
		<input type="submit" value="글쓰기">
	</form>
	<br>
	<br>
	<form action="/Board/First" method="POST">
		<input type="hidden" value="${user.userid}" name="userid">
		<input type="submit" value="메인화면">
	</form>
</body>
</html>