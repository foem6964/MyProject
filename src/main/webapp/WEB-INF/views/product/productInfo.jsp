<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>

<title>product</title>
<style type="text/css">
body {
	padding-top: 180px;
}       
</style>
</head>
<body>
		<%@ include file = "/WEB-INF/views/header.jsp" %>
		
	<div class="container" id="container">
		<div class="row">
			<div class="col-1"></div>
		
			<div id="image" style="box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);"></div>
			
			<div class="col-2"></div>

			<div class="col-4">
				<div id="box" class="card invisible">
					<div class="card-body">
						<h2 id="pname"></h2>  
						<div class="row">
							<div class="col-sm-6"><h3 id="SalePrice"></h3></div>
							<div class="col-sm-5"><h4 style="color: grey;padding-top: 5px"><del id="price"></del></h4></div>
						</div>
						<div onclick="cart();" role="button" id="btnCart" class="btn btn-primary"></div>
						
					</div>
				</div>
			</div>
			
		</div>
	</div>

</body>

<script type="text/javascript">

	function loadDoc(value =${ProductCode}) {
		let req = new XMLHttpRequest();
		req.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				//console.log(this);
				//console.log(this.response);
				myFunction(this);
			}
		};
		req.open("GET", 
				 "https://thingproxy.freeboard.io/fetch/https://openapi.11st.co.kr/openapi/OpenApiService.tmall?key=4a972a13f9e22b164bbe473d226d2dd3&apiCode=ProductSearch&"
				+"keyword=" + value, 
				  true);
		req.send();
	}

	function myFunction(xml) {
		let xmlDoc = xml.responseXML;

		let image = xmlDoc.getElementsByTagName("ProductImage300")[0].firstChild.data;
		let img = document.createElement("img"); 
		img.setAttribute("src", image);
		document.getElementById("image").append(img); 

		var pname = xmlDoc.getElementsByTagName("ProductName")[0].firstChild.data;
		document.getElementById("pname").innerHTML = pname;

		let SalePrice = xmlDoc.getElementsByTagName("SalePrice")[0].firstChild.data;
		document.getElementById("SalePrice").innerHTML = SalePrice + "원";
		
		let price = xmlDoc.getElementsByTagName("ProductPrice")[0].firstChild.data;
		if(SalePrice != price){
			document.getElementById("price").innerHTML = price+ "원";
		}else{
			document.getElementById("price").setAttribute("class", "hidden");
		}

		document.getElementById("btnCart").innerHTML = "장바구니에 담기";
		//document.getElementById("btnCart").setAttribute("class", "btn btn-primary");
		
		
		document.getElementById("box").setAttribute("class", "card");

	}

	document.addEventListener('DOMContentLoaded', () => {
		//console.log('DOMContentLoaded !!');
		loadDoc();

		var search = document.getElementById('search');
		// console.log('search.value', search.value);
		
		search.addEventListener("keyup", event => { //검색창에 엔터 키 입력시 검색 시작 기능
		  if (event.keyCode === 13) {
			  //console.log('엔터입력!!', event.keyCode);
			  //loadDoc(search.value);
			  document.location.href = "productList?searchValue="+search.value;
		  }
		}); 
	});

	function cart(){
		document.location.href = "/cart/add/"+${ProductCode};
	}
	

</script>
</html>