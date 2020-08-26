<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
.fileDrop{
	width: 80%;
	height: 200px;
	border: 1px dotted red; 
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">상품등록</h5>
            <form class="form-signin" action="/product/insert" method="post">
              <div class="form-label-group">
              	<c:if test="${not empty session}">
                <input type="hidden" id="sellerNick" value="${session}" class="form-control" placeholder="판매자닉네임" required autofocus>
                <input type="hidden" id="seller" value="${session}" class="form-control" placeholder="판매자" required autofocus>
              	</c:if>
                <input type="text" id="pName" class="form-control" placeholder="상품 제목을 입력" required autofocus>
                <label for="pName">상품제목</label>
                <input type="number" id="pPrice" class="form-control" placeholder="1개당 가격을 입력" required autofocus>
                <label for="pPrice">상품가격(개당)</label>
                <input type="number" id="discount" class="form-control" placeholder="할인율" required autofocus>
                <label for="discount">할인율</label>
                <input id=salePrice class="form-control" placeholder="할인가격" required autofocus>
                <label for="salePrice">할인된가격</label>
                <input type="number" id="delivery" class="form-control" placeholder="받을 배달비" required autofocus>
                <label for="delivery">배달가격</label>
                <input type="number" id="mileage" class="form-control" placeholder="마일리지" required autofocus>
                <label for="mileage">마일리지</label>
                <input type="email" id="Invntry" class="form-control" placeholder="재고 수량을 입력" required autofocus>
                <label for="Invntry">재고 량</label>
                <input type="text" id="detailText" class="form-control" placeholder="재고 수량을 입력" required autofocus>
                <label for="detailText">상품 소개글</label>
              </div>
              
              <hr class="my-4">
              <h3 class="text-center pImage">상품이미지등록</h3>
			  <div class="text-center" style="border-radius: 1rem;">
			  	<div class="fileDrop"></div>
			  	<div class="uploadList"></div>
			  </div>
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">등록</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
<script type="text/javascript">
	$(document).ready(function(){
			$(".fileDrop").on("dragenter dragover", function(event){
					event.preventDefault();
			});
			
			$(".fileDrop").on("drop", function(event){
					event.preventDefault();
					var files = event.originalEvent.dataTransfer.files;
					for(var i = 0; i < files.length; i++) {
					}
					
					var file = files[0];
					
					var formData = new FormData();
					formData.append("file", file);
					
					$.ajax({
							type : 'post',
							url : '/uploadajax',
							dataType : 'text',
							data : formData,
							processData : false,
							contentType : false,
							success : function(result){
									var name = result.split("_");
									console.log(result);
									console.log(name);
									var str = "<div><a href = '/displayfile?filename="+getImageLink(result)+"'>";

									if(checkImage(result)){
										str += "<img src ='/displayfile?filename="+result+"'/>"
									} else {
										str += "<img src = '/resources/show.png'/>"
									}
									str += getOriginalName(result);
									str += "</a><button class='deletefile2' data-name='"+result+"'> 🗑 </button></div>";
									$(".uploadList").append(str);
							},
					});
			});
			
			$(".uploadList").on("click", ".deletefile2", function(event){
				event.preventDefault();
				var that = $(this);
				$.ajax({
					type : 'post',
					url : '/deletefile2',
					dataType : 'text',
					data : {
						filename : $(this).attr("data-name")
					},
					success: function(result){
						alert(result);
						that.parent("div").remove();
					}
				});
			});
			
			$(document).on("click", ".deletebtn1", function(event){
					event.preventDefault();
					var filename = $(this).attr("data-name");
					filename = encodeURI(filename)
					console.log(filename)
					filename = decodeURI(filename)
					console.log(filename)
					$(this).parent().remove();
					$.ajax({
						type : 'delete',
						url : '/deletefile',
						headers : {
							"Content-Type" : "application/json",
							"X-HTTP-Method-Override" : "DELETE"
						},
						dataType : 'text',
						data : JSON.stringify({
							filename : filename
						}),
						success : function(result){
								alert("is delete!")
						},
						error : function(requset, status, error){
							alert("fail");
							console.log(error);
					}
					});
			});
			
			function getImageLink(result){
				  if(checkImage(result)){
				  	 return result.substring(0,12) + result.substring(14);
				  }else{
				  	 return result;
				  }
			 }
									
			function getOriginalName(fileName) {
					var cutUnderBar = (i) => i.substring(i.indexOf('_')+1);
					if(checkImage(fileName)){
							return cutUnderBar(cutUnderBar(fileName));
					} else {
							return cutUnderBar(fileName);
					}
			}
			
			function checkImage(fileName) {
					var idx = fileName.lastIndexOf(".");
					var f = fileName.substring(idx+1).toUpperCase();
					if(f=='PNG' ||f=='JPEG' ||f=='JPG' ||f=='GIF'){
							return true;
					} else {
							return false;
					}
			}
	});
</script>
</body>
</html>