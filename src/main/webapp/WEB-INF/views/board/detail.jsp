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
	
	function writeReply() {
		if (userid == null || userid == '') {
			alert('로그인이 필요한 서비스입니다.');
			return false;
		} else {
			alert('댓글이 작성 되었습니다.');
		}
	}
	
	function logout() {
		if (!confirm('로그아웃 하시겠습니까?')) {
			return false;
		}
	}
	
	function deleteReply() {
		if (confirm('삭제 하시겠습니까?')) {
			alert('댓글이 삭제 되었습니다.');
		} else {
			return false;
		}
	}
	
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
	<!-- 비 로그인 상태일 시 출력 -->
	<c:if test="${user.userid eq null}">
		
		<h2 style="float:left; margin-right:440px;">게시글 상세보기</h2>
		
		<form style="float:left; margin-top:25px;" action="/Login/LoginForm" method="POST">
		 	<input type="submit" value="로그인">
		</form>
		
	</c:if>
	
	<!-- 로그인 상태일 시 출력 -->
	<c:if test="${user.userid ne null}">
		
		<h2 style="float:left; margin-right:261px;">게시글 상세보기</h2>
		
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
		
	</c:if><br><br><br>
	
	<h3>제목 : ${detail.boardtitle}</h3>
	
	<p>
		작성자 &nbsp;&nbsp;&nbsp;: ${detail.boardwriter}<br>
		카테고리 : ${detail.boardmenu}<br>
		조회 수 &nbsp;&nbsp;: ${detail.readcount}<br>
		작성일자 : ${detail.boardindate} , 수정일자 : ${detail.boardupdate}
	</p>
	
	<textarea cols="100" rows="30" readonly="readonly">${detail.boardcontent}</textarea>
	<br><br>
	<c:if test="${reply ne null}">
		<div><b>댓글</b></div>
		<table border="1">
			<tr>
			<th>작성자</th>
			<th>댓글 내용</th>
			<th>작성일자</th>
			<th>수정일자</th>
			<th>수정 및 삭제</th>
			</tr>
			<c:forEach items="${reply}" var="m">
				<tr>
				<td>${m.replywriter}</td>
				<td><textarea cols="50" rows="3" readonly>${m.replycontent}</textarea></td>
				<td align=center>${m.replyindate}</td>
				<td align=center>${m.replyupdate}</td>
				<td>
				<!-- 댓글 작성자만 댓글 수정 및 삭제 하도록 설정 -->
				<c:if test="${user.userid eq m.replywriter}">
					<form style="float:left; margin-left:3px; margin-right:5px;" action="/Reply/UpdateForm" method="POST">
					   <input type="hidden" value="${m.replyidx}" name="replyidx">
					   <input type="submit" value="수정">
					</form>
					<form style="float:left; margin-right:3px;" action="/Reply/Delete" method="POST" onsubmit="return deleteReply();">
					   <input type="hidden" value="${m.replyidx}" name="replyidx">
					   <input type="submit" value="삭제">
					</form>
				</c:if>
				</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br>
	<br>
	<form action="/Reply/Write" method="POST" onsubmit="return writeReply();">
		<input type="hidden" value="${user.userid}" name="userid">
		<input type="hidden" value="${detail.boardidx}" name="boardidx">
		<textarea style="float:left; margin-right:10px;" cols="80" rows="6" name="replycontent" required></textarea>
		<input type="submit" value="댓글 작성">
	</form>
	
	<br><br><br><br><br>
	
	<!-- 게시글 작성자만 게시글 수정 및 삭제 하도록 설정 -->
	<c:if test="${user.userid eq detail.boardwriter}">
		<form style="float:left; margin-right:10px;" action="/Board/UpdateForm" method="POST">
		   <input type="hidden" value="${user.userid}" name="userid">
		   <input type="hidden" value="${detail.boardidx}" name="boardidx">
		   <input type="submit" value="게시글 수정">
		</form>
		<form action="/Board/Delete" method="POST" onsubmit="return deleteBoard();">
		   <input type="hidden" value="${user.userid}" name="userid">
		   <input type="hidden" value="${detail.boardidx}" name="boardidx">
		   <input type="submit" value="게시글 삭제">
		</form>
	</c:if>
	<br>
	<br>
	<form action="/Board/List" method="POST">
		<input type="hidden" value="${user.userid}" name="userid">
		<input type="submit" value="목록으로">
	</form>
</body>
</html>