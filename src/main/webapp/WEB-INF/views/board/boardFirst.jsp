<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.basic.user.vo.UserVo" %>
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
	<% 
		UserVo userInfo = (UserVo) request.getAttribute("user");
		String username = userInfo.getUsername();
		String adminToken = userInfo.getAdminToken();
	%>
	<h2><%=username %>님 안녕하세요.</h2>
	
	<% if (adminToken.equals("0")) { %>
	<a href="/Login/Logout">로그아웃</a>
	<% } else if (adminToken.equals("1")) { %>
	<a href="/Login/Logout">로그아웃</a>
	<a href="/User/List">회원목록</a>
	<% } %>
	
</body>
</html>