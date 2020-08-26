<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>

<body>



<div class = "container">
<h1>관리자 페이지</h1>
<form action = "/admin/loginpost" method = "post">
<div class="form-group">
	<label for= "id">ID:</label>
	<input name ="id" class = "form-control"><br>
</div>

<div class="form-group">
	<label for = "pw">pw</label>
	<input class ="form-control" name = "pw"><br>
</div>

	<button type="submit" class ="btn btn-default">login</button>
</form>
</div>
</body>
</html>