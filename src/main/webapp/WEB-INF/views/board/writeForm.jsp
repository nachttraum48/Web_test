<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
	<!-- 클래식 에디터 -->
	<script src="https://cdn.ckeditor.com/ckeditor5/29.1.0/classic/ckeditor.js"></script>
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<link rel="stylesheet" href="/css/common.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	window.onload = function() {
		ClassicEditor
        .create( document.querySelector( '#classic' ))
        .catch( error => {
            console.error( error );
        } );
	}
</script>

<!-- 넓이 높이 조절 -->
<style>
	.ck.ck-editor {
	   	max-width: 1000px;
	}
	.ck-editor__editable {
	    min-height: 500px;
	}
</style>
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
		<input type="text" id="classic" name="boardcontent">
		
		<!-- <textarea cols="100" rows="30" name="boardcontent"></textarea> -->
		<br>
		<br>
		<input type="submit" value="작성하기">
	</form>
	
</body>
</html>