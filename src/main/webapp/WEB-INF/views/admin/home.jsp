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
<style type="text/css">
.flex-container {
	display: flex;
	justify-content: center;
	flex-wrap: wrap;
}

.flex-item1 {
	margin-left: 300px;
}

.flex-item2 {
	flex-basis: 800px;
}
</style>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="">이름 없음</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="즐겨찾기">Home</a></li>
				<li><a href="#">MY PAGE</a></li>
				<li class="dropdown"><a href="#"class="dropdown-toggle" data-toggle="dropdown">고객센터<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="/admin/FAQ'">FAQ</a></li>
						<li><a href="/admin/1to1'">1:1문의하기</a></li>
						<li><a href="/admin/Noticeboardlist">공지사항</a></li>
						</ul>
						</li>
	
					</ul>
				

	
		<ul class="nav navbar-nav navbar-right">
		
		</div>
	</nav>

	<div class="flex-container">
		<div class="flex-item3">
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					Dropdown Example <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="#">HTML</a></li>
					<li><a href="#">CSS</a></li>
					<li><a href="#">JavaScript</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="flex-item1">
		<h1>쇼핑몰이름</h1>
	</div>
	<div class="flex-item2">
		<form target="_blank" action="/admin/searchlist" method="get">
			<div class="input-group">
				<span class="input-group-addon"> <select name="searchType">
						<option disabled>검색 기준</option>
						<option value="shirt">셔츠</option>
						<option value="pants">바지</option>
						<option value="shoes">신발</option>
				</select>
				</span> <input class="form-control" name="keyword"> <span
					class="input-group-btn">
					<button class="btn btn-info">검색</button>

				</span>
			</div>
		</form>

	</div>



	</div>


	<div class="col-md-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">Panel Title</h3>
			</div>

			<ul class="list-group">
				<li class="list-group-item"><a href="#">HTML</a></li>
				<li class="list-group-item"><a href="#">CSS</a></li>
				<li class="list-group-item"><a href="#">ECMAScript5</a></li>
			</ul>
		</div>

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Panel Title</h3>
			</div>

			<ul class="list-group">
				<li class="list-group-item"><a href="#">jQuery</a></li>
				<li class="list-group-item"><a href="#">BootStrap</a></li>
			</ul>
		</div>

		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">Panel Title</h3>
			</div>

			<ul class="list-group">
				<li class="list-group-item"><a href="#">About</a></li>
				<li class="list-group-item"><a href="#">Help</a></li>
			</ul>
		</div>
	</div>

</body>
</html>