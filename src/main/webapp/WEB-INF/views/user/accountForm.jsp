<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
   
      $(document).submit(function(e){
         var usernameEl = document.getElementById('username');
         var username = usernameEl.value
         
         
         if ( username == null || username == '' ){
            
         alert('이름을 입력해주세요.');
         usernameEl.focus();
         return false;
         
         }else{
            alert('회원가입되었습니다.');
         }
      })
   
</script>
</head>

<body>
	<h2>회원가입</h2>
	<form action="/User/Account" id="form2" method="POST">
		<span>이름</span> <input type="text" maxlength="20" name="username" id="username">
		<br>
		<span>ID</span> <input type="text" maxlength="20" name="userid">
		<br>
		<span>PW</span> <input type="password" maxlength="20" name="userpw">
		<br>
		<!-- name이 키 값이다. -->
		<!-- <input type="button" value="로그인"> -->
		<input type="submit" value="회원가입">
	</form>
	<a href="/">메인화면</a>
</body>
</html>