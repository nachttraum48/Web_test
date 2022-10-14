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
			alert('댓글이 수정 되었습니다.');
		} else {
			return false;
		}
	}
	
</script>
</head>

<body>
	<h3>댓글 수정</h3>
	
	<form action="/Reply/Update" method="Post" onsubmit="return update();">
		<textarea style="float:left; margin-right:10px;" cols="80" rows="10" name="replycontent" required>${update.replycontent}</textarea>
		<br>
		<br>
		<input type="hidden" value="${update.replyidx}" name="replyidx">
		<input type="submit" value="수정">
	</form>
</body>
</html>