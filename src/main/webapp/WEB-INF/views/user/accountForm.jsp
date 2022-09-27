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
	    var useridEl = document.getElementById('userid');
	    var userid = useridEl.value
	    var userpwEl = document.getElementById('userpw');
	    var userpw = userpwEl.value
		var idReg = /^[a-z]+[a-z0-9]{5,19}$/g;
		
	    if ( !idReg.test( userid ) ) {
	        alert("아이디는 영문자로 시작하는 6 ~ 20의 영문자 또는 숫자이어야 합니다.");
	        return false;
	    }
	    if ( username == null || username == '' ){
	        alert('이름을 입력해주세요.');
	        usernameEl.focus();
	        return false;
	    }
	    if ( userid == null || userid == '' ){
	        alert('아이디를 입력해주세요.');
	        useridEl.focus();
	        return false;
	    }
	    if ( userpw == null || userpw == '' ){
	        alert('비밀번호를 입력해주세요.');
	        userpwEl.focus();
	        return false;
	        
	    } else {
	       alert('회원가입 되었습니다.');
	    }
	 })
   
</script>
</head>

<body>
	<h2>회원가입</h2>
	<form action="/User/Account" method="POST">
		<span>이름</span> <input type="text" maxlength="20" name="username" id="username">
		<br>
		<span>ID</span> <input type="text" maxlength="20" name="userid" id="userid">
		<br>
		<span>PW</span> <input type="password" maxlength="20" name="userpw" id="userpw">
		<br>
		<!-- name이 키 값이다. -->
		<!-- <input type="button" value="로그인"> -->
		<input type="submit" value="회원가입">
	</form>
	<a href="/">메인화면</a>
</body>
</html>