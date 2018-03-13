<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>회원가입 or 로그인</title>
</head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
<form action="newAccount">
아이디 	:<input type="text" id="id"><br/>
비밀번호      :<input type="text" id="pw"><br/>
이메일      :<input type="text" id="email"><br/>
<button type="submit">회원가입</button><br/>
</form>
<form action="login">
아이디 	:<input type="text" id="id"><br/>
비밀번호      :<input type="text" id="pw"><br/>
<button type="submit">로그인</button>
</form>
<div>
<small>현재 접속자수: <span id="userAmount"></span></small><br/>
<small>로그: <span id="log"></span></small>

</div>
</body>
<script>
	var ws = new WebSocket("ws://${pageContext.request.serverName}/handle");
	// 로컬 호스트로 접근하려면 아이피가 아니라 localhost써야함.
	ws.onopen = function(){
		console.log("socket open succeed");
	}
	var cnt=1;
	ws.onmessage = function(obj){
		if(cnt==1){
		$("#userAmount").html(obj.data);
		}
		if(cnt==2){
		console.log(obj.data);	
		$("#log").html(obj.data);
		}
		cnt++;
		if(cnt==3){
			cnt=1;
		}
	}
	ws.onclose =function(){
		window.alert("socket closed");
	}
</script>
</html>
