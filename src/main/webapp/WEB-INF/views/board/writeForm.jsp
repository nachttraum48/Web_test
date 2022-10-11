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
	<h2>게시글 작성</h2>
	
	<form action="/Board/Write" method="Post">
		<span style="margin-right:31px;">제목</span> <input type="text" maxlength="20" name="boardtitle"> <br>
		<span style="margin-right:15px;">작성자</span> <input type="text" value="${user.userid}" name="boardwriter" readonly="readonly">
		<br>
		<span>카테고리</span>
		
		<select name="boardmenu" required>
		    <option value="">카테고리</option>
		    
		    <c:forEach items="${menu}" var="m">
		    	<option value="${m.menuname}">${m.menuname}</option>
		    </c:forEach>
		</select>
		<br>
		<br>
		<span>내용</span> <br>
		<textarea cols="100" rows="30" name="boardcontent"></textarea>
		<br>
		<br>
		<input type="submit" value="작성하기">
	</form>
	
</body>
</html>