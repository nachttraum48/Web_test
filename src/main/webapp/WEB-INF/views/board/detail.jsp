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
	
	function deleteBoard() {
		if (confirm('삭제 하시겠습니까?')) {
			alert('삭제 되었습니다.');
		} else {
			return false;
		}
	}
	
</script>
</head>

<body>
	<h2>게시글 상세보기</h2>
	
	<h3>제목 : ${detail.boardtitle}</h3>
	
	<p>
		작성자 &nbsp;&nbsp;&nbsp;: ${detail.boardwriter}<br>
		카테고리 : ${detail.boardmenu}<br>
		조회 수 &nbsp;&nbsp;: ${detail.readcount}<br>
		작성일자 : ${detail.boardindate}, 수정일자 : ${detail.boardupdate}
	</p>
	
	<textarea cols="100" rows="30" readonly="readonly">${detail.boardcontent}</textarea>
	<br>
	
	<!-- 작성자만 수정 및 삭제 하도록 설정 -->
	<c:if test="${user.userid eq detail.boardwriter}">
		<form style="float:left; margin-right:10px;" action="/Board/UpdateForm" method="POST">
		   <input type="hidden" value="${user.userid}" name="userid">
		   <input type="hidden" value="${detail.boardidx}" name="boardidx">
		   <input type="submit" value="수정">
		</form>
		<form action="/Board/Delete" method="POST" onsubmit="return deleteBoard();">
		   <input type="hidden" value="${user.userid}" name="userid">
		   <input type="hidden" value="${detail.boardidx}" name="boardidx">
		   <input type="submit" value="삭제">
		</form>
	</c:if>
	
</body>
</html>