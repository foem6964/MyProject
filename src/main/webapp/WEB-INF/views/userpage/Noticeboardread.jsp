<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	
	<div class="container">
		<div class="row text-center">
			<h1>공지사항</h1>
		</div>
		<div class="row">
			<div class="form-group">
				<label for="title">제목</label> <input readonly value="${vo.title}"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="writer">작성자</label> <input readonly value="${vo.writer}"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea readonly rows="5" class="form-control">${vo.content}</textarea>
			</div>
			

				
			

		</div>

			</div>
			
			
			<button class="btn btn-danger" id="list">목록으로가기</button>
			
	
	
	<script type="text/javascript">
	$(document).ready(function(){
	$("#list").click(function() {
		location.assign("/userpage/Noticeboardlist")

	});
	});

	</script>
	

	
	
	

	
</body>
	
</html>
