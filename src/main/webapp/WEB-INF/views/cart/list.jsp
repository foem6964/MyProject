<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>

<!-- 

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

 -->

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<title>장바구니</title>

</head>

<body>

<section class="pt-5 pb-5">

  <div class="container">

    <div class="row w-100">

        <div class="col-lg-12 col-md-12 col-12">

            <h3 class="display-5 mb-2 text-center">장바구니</h3>

            <p class="mb-5 text-center">

                <i class="text-info font-weight-bold">${fn:length(cartList)} </i> 개가 장바구니에 담겼습니다</p>

            <table id="shoppingCart" class="table table-condensed table-responsive">

                <thead>

                    <tr>

                        <th style="width:60%">상품이름</th>

                        <th style="width:12%">가격</th>

                        <th style="width:10%">개수</th>

                        <th style="width:16%"></th>

                    </tr>

                </thead>

                <tbody>

                <c:forEach items="${cartList}" var="dto">

                    <tr>

                        <td class="Product">

                            <div class="row">

                                <div class="col-md-3 text-left">

                                    <img src="${dto.PImage}" alt="상품이미지" class="img-fluid d-none d-md-block rounded mb-2 shadow ">

                                </div>

                                <div class="col-md-9 text-left mt-sm-2">

                                    <h4><a href="${dto.getDetailPageUrl()}">${dto.PName}</a></h4>

                                    <p class="font-weight-light">${dto.getSellerNick()} &amp; ${dto.getSeller()}</p>

                                </div>

                            </div>

                        </td>

                        <td class="price1" data-th="${dto.PPrice}">${dto.PPrice}원</td>

                        <td class="price2" data-th="Quantity" data-price="${dto.PPrice}">

                            <select data-price="${dto.getPPrice()}" data-no="${dto.getC_no()}" class="quantity-select form-control form-control-lg text-center">

	                            <option value="1">1</option>

	                            <option value="2">2</option>

	                            <option value="3">3</option>

	                            <option value="4">4</option>

	                            <option value="5">5</option>

                            </select>

                        </td>

                        <td class="actions" data-th="">

                            <div class="text-right">

                           

                                <button data-cno="${dto.getC_no()}" class="delete_cart btn btn-white border-secondary bg-white btn-md mb-2">X</button>

                            </div>

                        </td>

                    </tr>

                 </c:forEach>

                </tbody>

            </table>

            <div class="float-right text-right">

                <h4>총 가격:</h4>

                <h1 id="total_price"></h1>

            </div>

        </div>

    </div>

    <div class="row mt-4 d-flex align-items-center">
			
        
        <div class="col-sm-6 order-md-2 text-right">

            <button class="btn btn-primary mb-4 btn-lg pl-5 pr-5" id="resultid">결재하기</button>
           

        </div>

        <div class="col-sm-6 mb-3 mb-m-1 order-md-1 text-md-left">

            <a href="/product/productList">

                <i class="fas fa-arrow-left mr-2"></i>계속 쇼핑하기</a>

        </div>

    </div>
        	<h3>배송지:</h3>
        	<h4>${loginUser.address}</h4>
  

</div>

</section>

<script type="text/javascript">
	$(document).ready(function(){
		
		var total = 0;
		$('.price1').each(
	       function(){
	           total += parseInt($(this).attr("data-th"));
	       }
		);

		//console.log("total: "+ total);
		$("#total_price").append(total);
			$('.price2').change(function(){
			var sumArray = [];
			//console.log($("[class^=price2]"));
			$("[class^=price2]").each(function (result) {
				let indcount = $(this).children("select").val();
				let indprice = $(this).attr("data-price");
				console.log("indcount: "+indcount);
				console.log("indprice: "+indprice);

				var sum = 0;
				sum = indcount * indprice;
				sumArray.push(sum);
				//console.log("sum: "+sum);
				//console.log("==============================================", sumArray);
				 });

			$("#total_price").text("");
		
			var result = 0;
			for(var i=0; i < sumArray.length; i++) {
				result += sumArray[i];
			}
				
			$("#total_price").text(result);
			//console.log(result);
			$("#resultid").click(function(){
				let result = Number($("#total_price").text());
				document.location.href='/pay/kakaopay?result='+result+'';
				});
		
		});
			
		
		$(".delete_cart").on("click", function(){
			let a = $(this);
			const c_no = $(this).attr("data-cno");
			$.ajax({
				type : 'DELETE',
				url : '/cart/delete/'+c_no,
				headers : {
					"Content-Type" : "application/json",

					"X-HTTP-Method-Override" : "DELETE"

				},
				

				dataType : "text",

				data : JSON.stringify({

					c_no : c_no

				}),

				success : function(result){

					if(result!="success"){

						$(location).prop('href',"/users/login");

					}

					a.parent().parent().parent().remove();

				},

				error : function(requset, status, error){

					console.log(error);

				}

			});

		});

		

	});
		
	    


	

	

</script>

</body>

</html>