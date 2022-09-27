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
         var userpwEl = document.getElementById('userpw');
         var userpw = userpwEl.value
         
         
         if (confirm('수정하시겠습니까?')) {
	         if ( username == null || username == '' ){
		         alert('이름을 입력해주세요.');
		         usernameEl.focus();
		         return false;
	         }
	         if ( userpw == null || userpw == '' ){
		         alert('비밀번호를 입력해주세요.');
		         userpwEl.focus();
		         return false;
		         
	         } else {
	            alert('회원정보가 수정되었습니다.');
	         }
         } else {
        	 return false;
         }
      })
   
</script>
</head>

<body>
	<h2>회원정보 수정</h2>
	<h6>ID는 수정이 불가합니다!</h6>
	<form action="/User/Update" method="POST">
		<span>이름</span> <input value="${update.username}" maxlength="20" name="username" id="username">
		<br>
		<span>ID</span> <input value="${update.userid}" name="userid" readonly="readonly">
		<br>
		<span>PW</span> <input type="password" placeholder="새 비밀번호 입력" maxlength="20" name="userpw" id="userpw">
		<br>
		<!-- name이 키 값이다. -->
		<!-- <input type="button" value="로그인"> -->
		<input type="submit" value="수정">
	</form>
	<a href="/">메인화면</a>
</body>
</html>