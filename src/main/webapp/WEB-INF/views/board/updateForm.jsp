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
	
	function logout() {
		if (!confirm('로그아웃 하시겠습니까?')) {
			return false;
		}
	}
	
	function update() {
		if (confirm('수정 하시겠습니까?')) {
			alert('수정 되었습니다.');
		} else {
			return false;
		}
	}
	
</script>
</head>

<body>
	<h2 style="float:left; margin-right:309px;">게시글 수정</h2>
	
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
		
	</c:if><br><br><br><br>
	
	<form action="/Board/Update" method="Post" onsubmit="return update();">
		<span style="margin-right:31px;">제목</span> <input value="${update.boardtitle}" placeholder="새로운 제목 입력" maxlength="20" name="boardtitle" required> <br>
		<span style="margin-right:15px;">작성자</span> <input value="${user.userid}" readonly="readonly">
		<br>
		<span>카테고리</span>
		
		<select name="boardmenu" required>
		    <option value="">카테고리</option>
		    
		    <c:forEach items="${menu}" var="m">
		    	<option value="${m.menuname}">${m.menuname}</option>
		    </c:forEach>
		    
		</select>
		<br>
		<span>내용</span> <br>
		<textarea cols="100" rows="30" name="boardcontent">${update.boardcontent}</textarea>
		<br>
		<br>
		<input type="hidden" value="${user.userid}" name="userid">
		<input type="hidden" value="${update.boardidx}" name="boardidx">
		<input type="submit" value="수정">
	</form>
	
</body>
</html>