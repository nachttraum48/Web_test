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
	
	var userid = `${user.userid}`;
	
	function writeBoard() {
		if (userid == null || userid == '') {
			alert('로그인이 필요한 서비스입니다.');
			return false;
		}
	}
	
	function logout() {
		if (!confirm('로그아웃 하시겠습니까?')) {
			return false;
		}
	}
	
</script>
</head>

<body>
	<!-- 비 로그인 상태일 시 출력 -->
	<c:if test="${user.userid eq null}">
		
		<h2 style="float:left; margin-right:545px;">게시판</h2>
		
		<form style="float:left; margin-top:25px;" action="/Login/LoginForm" method="POST">
		 	<input type="submit" value="로그인">
		</form>
		
	</c:if>
	
	<!-- 로그인 상태일 시 출력 -->
	<c:if test="${user.userid ne null}">
		<h2 style="float:left; margin-right:365px;">게시판</h2>
		
		<!-- 로그인 유저 정보 -->
		<span style="float:left; margin-top:25px; margin-right:10px;"><strong>${user.username}</strong>님</span>
		
		<form style="float:left; margin-top:25px; margin-right:10px;" action="/Login/Logout" method="POST" onsubmit="return logout();">
		 	<input type="submit" value="로그아웃">
		</form>
		
		<c:if test="${user.adminToken ne null}">
			
			<c:if test="${user.adminToken eq '0'}">
				<form style="float:left; margin-top:25px;" action="/User/Detail" method="POST">
					<input type="hidden" value="${user.userid}" name="userid">
					<input type="submit" value="마이페이지">
				</form>
			</c:if>
			<c:if test="${user.adminToken eq '1'}">
				<form style="float:left; margin-top:25px;" action="/User/List" method="POST">
					<input type="submit" value="회원관리">
				</form>
			</c:if>
			
		</c:if>
	</c:if><br><br><br><br>
	
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
			<form action="/Board/List" method="POST">
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
	<table border="1" >
		<tr>
		<th>번호</th>
		<th>카테고리</th>
		<th width="300">제목</th>
		<th>작성자</th>
		<th>작성일자</th>
		<th>수정일자</th>
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
			<td align=center>${m.boardindate}</td>
			<td align=center>${m.boardupdate}</td>
			<td>${m.readcount}</td>
			</tr>
		</c:forEach>
		
		<c:if test="${board eq null}">
			<tr><td style="background:lightgray;" height="80" colspan="7" align=center><b>게시글이 존재하지 않습니다.</b></td></tr>
		</c:if>
	</table>
	<br>
	<!-- 게시글 검색 -->
	<form action="/Board/Search" method="POST">
	  	<input type="hidden" value="${user.userid}" name="userid">
	  	
		<select name="searchType">
	       <option value="title" selected>제목</option>
	       <option value="content">내용</option>
	       <option value="writer">작성자</option>
	  	</select>
	  	
	  	<input type="text" name="searchText">
		<input type="submit" value="검색">
	</form>
	<br>
	<form action="/Board/WriteForm" method="POST" onsubmit="return writeBoard();">
		<input type="hidden" value="${user.userid}" name="userid">
		<input type="submit" value="글쓰기">
	</form>
	<br>
	<!-- 비 로그인 시 메인화면 다르게 출력 -->
	<c:if test="${user.userid eq null}">
		<form action="/" method="POST">
			<input type="submit" value="메인화면">
		</form>
	</c:if>
	<c:if test="${user.userid ne null}">
		<form action="/Board/First" method="POST">
			<input type="hidden" value="${user.userid}" name="userid">
			<input type="submit" value="메인화면">
		</form>
	</c:if>
</body>
</html>