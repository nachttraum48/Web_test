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
	<h3>게시판 메뉴 수정</h3>
	
	<form action="/Menu/Update" method="Post" onsubmit="return update();">
		<span>메뉴 이름</span> <input value="${update.menuname}" placeholder="새로운 이름 입력" maxlength="10" name="newname" required>
		<br>
		<br>
		<input type="hidden" value="${update.menuname}" name="menuname">
		<input type="submit" value="수정">
	</form>
</body>
</html>