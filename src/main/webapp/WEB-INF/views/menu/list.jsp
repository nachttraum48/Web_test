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
	
	function deleteMenu() {
		if (confirm('삭제 하시겠습니까?')) {
			alert('삭제 되었습니다.');
		} else {
			return false;
		}
	}
	
</script>
</head>

<body>
	<h2>메뉴 목록</h2>
	
	<a href="/Menu/CreateForm">메뉴 생성</a>
	<br>
	<br>
	<table border="1">
		<tr>
		<th>번호</th>
		<th>이름</th>
		<th>생성일자</th>
		<th>수정일자</th>
		<th>수정 및 삭제</th>
		</tr>
		<c:forEach items="${list}" var="m">
		<tr>
		<td>${m.menuidx}</td>
		<td>${m.menuname}</td>
		<td align=center>${m.menuindate}</td>
		<td align=center>${m.menuupdate}</td>
		<td>
			<form style="float:left; margin-left:3px; margin-right:5px;" action="/Menu/UpdateForm" method="POST">
			   <input type="hidden" value="${m.menuname}" name="menuname">
			   <input type="submit" value="수정">
			</form>
			<form style="float:left; margin-right:3px;" action="/Menu/Delete" method="POST" onsubmit="return deleteMenu();">
			   <input type="hidden" value="${m.menuname}" name="menuname">
			   <input type="submit" value="삭제">
			</form>
		</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>