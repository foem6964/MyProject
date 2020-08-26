<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
<style type="text/css">
.row{
margin:100px;

}

</style>
</head>

<body>
<%@ include file = "/WEB-INF/views/header.jsp" %>
	<div class="container">
		<div class="row text-center">
			<h1>FAQ</h1>
		</div>

		<div class="row">
		
			<a href="/admin/faqinsert">글쓰기</a>
			
		
			

			<table class="table">
				<thead>
					<tr>
						<th class="th-center">글번호</th>
						<th class="th-center" style="width: 50%">제목</th>
						<th class="th-center">작성자</th>
						<th class="th-center">작성일</th>
						<th class="th-center">조회수</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${list}" var="dto">
						<tr>
							<td>${dto.bno}</td>
							<td><a href="/admin/faqread/${dto.bno}">${dto.title}</a></td>
							<td>${dto.writer}</td>
							<td>${dto.regDate}</td>
							<td>${dto.viewcnt}</td>

						</tr>

					</c:forEach>

				</tbody>

			</table>
		</div>
		<div class="row">
			<form target="_blank" action="/admin/faqsearchlist" method = "get">
				<div class="input-group">
					<span class="input-group-addon"> <select name="searchType">
							<option disabled>검색 기준</option>
							<option value="writer">전체</option>
							<option value="title">배송문제</option>
							<option value="content">로그인문제</option>
					</select>
				</span>
				
				<input class="form-control" name="keyword">
				<span class = "input-group-btn">
					<button class = "btn btn-info">검색</button>
				
				</span>
				</div>
			</form>



		</div>
	
	</div>
		<!-- class = row -->
		<div class="row text-center">
			<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><a href="/admin/faq?curPage=${to.curPage > 1? to.curPage-1 : 1}" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>
					<c:forEach begin ="${to.beginPageNum}" end = "${to.stopPageNum}" var = "page">
					<li class = "${to.curPage == page?'active' :''}"><a href="admin/faq?curPage=${page}">${page}</a>
					</c:forEach>
					
					<li><a href="admin/faq?curPage=${to.curPage < to.totalPage ? to.curPage+1 : to.totalPage}"aria-label="Next"> 
						<span aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</div>

</body>
</html>