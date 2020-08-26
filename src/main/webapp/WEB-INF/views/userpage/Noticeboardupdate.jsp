<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<%@ include file = "/WEB-INF/views/header.jsp" %>
<div class = "container">
	<div class = "row text-center">
	<div><h1>글수정</h1>
	</div>
	</div>
		<form action="/Noticeupdate" method="post">
		<input type = "hidden" name = "bno" value = "${vo.bno}">
			<div class = "form-group">
				<label for = "title">제목</label>
				<input value="${vo.title}" name = "title" id = "title" class = "form-control">	
			</div>
			<div class = "form-group">
				<label for = "writer">작성자</label>
				<input value = "${vo.writer}" name = "writer" id = "writer" class = "form-control">
			</div>
			
			<div class = "form-group">
				<label for = "content">내용</label>
				<textarea class = "form-control" value = "[수정]" id = "content"rows="5" name = "content">${vo.content}</textarea>
			</div>
		</form>

		
		<div class = "form-group">
			<button class ="btn btn-success" id ="updatebtn">수정</button>
			<button class ="btn btn-success"id="listbtn">목록</button>
		</div>
	</div>

<script type="text/javascript">
	var bno = ${vo.bno};
	$(document).ready(function() {					
		$("#updatebtn").click(function(){
			$("form").submit();

			});

		$("#listbtn").click(function(){
			location.assign("/qnaboard/list");
			
			});
		});
	

</script>


</body>
</html>