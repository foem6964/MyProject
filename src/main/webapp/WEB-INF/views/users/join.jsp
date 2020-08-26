<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>간편 회원가입</h1>
	<p>사용하실 이름을 입력하세요</p>
	<form action="/users/join" method="post">
		이름:<input name="name"><br>
		주소:<input name="address"><br>
		<input type="submit" value="입력">
	</form>
</body>
</html>