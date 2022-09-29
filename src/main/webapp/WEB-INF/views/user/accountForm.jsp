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

	function idCheck() {
		var useridEl = document.getElementById('userid');
	    var userid = useridEl.value
	}

	$(document).submit(function(e){
	    var useridEl = document.getElementById('userid');
	    var userid = useridEl.value
		var idReg = /^[a-z]+[a-z0-9]+$/g;
	    
	    var usernameEl = document.getElementById('username');
	    var username = usernameEl.value
	    
	    var userpwEl = document.getElementById('userpw');
	    var userpw = userpwEl.value
	    var pwConfirmEl = document.getElementById('pwConfirm');
	    var pwConfirm = pwConfirmEl.value
		
	    if ( userid == null || userid == '' ){
	        alert('아이디를 입력해주세요.');
	        useridEl.focus();
	        return false;
	    }
	    if ( !idReg.test( userid ) ) {
	        alert("아이디는 영문자로 시작하고 영문자 또는 숫자로 끝나야 합니다.");
	        return false;
	    }
	    if ( username == null || username == '' ){
	        alert('이름을 입력해주세요.');
	        usernameEl.focus();
	        return false;
	    }
	    if ( userpw == null || userpw == '' ){
	        alert('비밀번호를 입력해주세요.');
	        userpwEl.focus();
	        return false;
	        
	    }
	    if ( pwConfirm == null || pwConfirm == '' ){
	        alert('비밀번호 확인을 입력해주세요.');
	        pwConfirmEl.focus();
	        return false;
	        
	    }
	    if ( pwConfirm != userpw ) {
	    	alert('비밀번호가 일치하지 않습니다!');
	        pwConfirmEl.focus();
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
		<span style="margin-right:31px;">이름</span> <input type="text" maxlength="20" name="username" id="username">
		<br>
		<span style="margin-right:47px;">ID</span> <input type="text" maxlength="20" name="userid" id="userid">
		<input type="button" value="중복확인" onclick="idCheck()">
		<br>
		<span style="margin-right:38px;">PW</span> <input type="password" maxlength="20" name="userpw" id="userpw">
		<br>
		<span>PW 확인</span> <input type="password" maxlength="20" id="pwConfirm">
		<br>
		<br>
		<!-- name이 키 값이다. name 속성 없으면 값이 안넘어감 -->
		<input type="submit" value="회원가입">
	</form>
	<br>
	<a href="/">메인화면</a>
</body>
</html>