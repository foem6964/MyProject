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
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	

<title>Insert title here</title>
</head>
<body>

	
	<div class="container">
		<div class="row text-center">
			<h1>FAQ</h1>
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
			

				
			

	<div class="row">
	
			<c:if test="${sessionScope.loginUser.name == vo.writer}">
			<div class="form-group">
				<button class="btn btn-warning" id="update">수정</button>
				<button class="btn btn-primary" id="delete">삭제</button>
			</div>
			</c:if>
			
			
				<button class="btn btn-danger" id="list">목록</button>

		</div>
		<!-- class = row -->


		<!-- class = row -->


			<div id="replies" class="row">
				<div class="panel panel-success">
					<div class="panel-heading">
						<span>rno: 3</span>,<span>작성자: 홍길동</span> <span class="pull-ligth">2020년
							07월07일</span>
					</div>
					<div class="panel-body">
						<p>댓글 내용입니다</p>
					</div>

				</div>


			</div>


	

	</div>
	</div>
	
	
	
	<!-- class = container -->

	<script type="text/javascript">
		var bno = ${vo.bno};

		
		getList(bno);

		$(document).ready(function() {
			
			



			
			

			

			$(".modal-update-btn").click(function() {

				var rno = $(".modal-rno").text();
				var replytext = $(".modal-replytext").val();

				$.ajax({
					type : 'put',
					url : "/replies/" + rno,
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "PUT"
					},
					dataType : 'text',
					data : JSON.stringify({
						replytext : replytext
					}),
					success : function(result) {
						if (result === "success") {
							getList(bno);
						}
					},

				});

			});

			$("#replyInsertBtn").click(function() {
				

				var replyer = $("#replyer").val();
				var replytext = $("#replytext").val();
				
				$.ajax({

					type : 'post',

					url : '/replies',

					headers : {

						"Content-Type" : "application/json",

						"X-HTTP-Method-Override" : "POST"

					},

					dataType : "text",

					data : JSON.stringify({

						

						bno : bno,


						replyer : replyer,

						replytext : replytext,

						

						
					}),

					success : function(result) {
						$("#replyer").val("");
						$("#replytext").val("");

						getList(bno);

					},

					error : function(request, status, error) {

						console.log(error);

					}
				});
					


					});

			

			$("#reply_form").click(function() {
				$("#myCollapse").collapse("toggle");

			});
			$("#update").click(function() {
				location.assign("/userpage/faqupdate/${vo.bno}");

			});
			$("#delete").click(function() {
				location.assign("/userpage/faqdelete/${vo.bno}")

			});

			$("#list").click(function() {
				location.assign("/userpage/faq")

			});
		});

		function getList(bno) {

			var str = '';

			$.getJSON("/replies/all/" + bno,
							function(data) {

								for (var i = 0; i < data.length; i++) {
									str += '<div class="panel panel-success"><div class="panel-heading"><span>rno:'
											+ data[i]["rno"]
											+ '</span>,<span>작성자: '
											+ data[i]["replyer"]
											+ '</span><span class="pull-ligth">'
											+ data[i]["updatedate"]
											+ '</span></div><div class="panel-body"><p>'
											+ data[i]["replytext"]
											+ '</p><button data-name="'+data[i]["replyer"]+'</div></div>;'

								}
								$("#replies").html(str);

							});

		}
	</script>
</body>
</html>