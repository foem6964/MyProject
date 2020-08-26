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
<div class ="container">
		<div class = "row">
			<h1>검색 결과</h1>
			<p>검색 조건 : ${searchType}, 키워드:${keyword}</p>
		</div>
		<div class="row">

			<table class="table">
				<thead>
					<tr>
						<th class="th-center">글번호</th>
						<th class="th-center" style="width:50%">제목</th>
						<th class="th-center">작성자</th>
						<th class="th-center">작성일</th>
						<th class="th-center">조회수</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${list}" var="dto">
						<tr>
							<td>${dto.bno}</td>
							<td><a href="/userpage/read/${dto.bno}">${dto.title}</a></td>
							<td>${dto.writer}</td>
							<td>${dto.regDate}</td>
							<td>${dto.viewcnt}</td>

						</tr>

					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>
</body>
</html>